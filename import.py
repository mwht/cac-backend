#!/usr/bin/env python3
import psycopg2
import sys

exit_status = 0

if len(sys.argv) < 4:
    print ('usage:', sys.argv[0], '<input file> <parent card set ID> <BLACK|WHITE>')
    sys.exit(1)

input_filename = sys.argv[1]
parent_cardset_id = sys.argv[2]
cards_type = sys.argv[3]

print('[*] Importing file \'' + input_filename + '\' as card type', cards_type, 'for cardset ID', parent_cardset_id)
input_lines = []
try:
    with open(input_filename, encoding='utf-8') as input_file:
        input_lines = input_file.readlines()
except Exception as exception:
    print('[-] An exception occurred while loading dataset -', exception)
    sys.exit(1)

print('[+] Dataset loaded - lines to import:', len(input_lines))

try:
    print('[*] Connecting to PostgreSQL ...')
    connection = psycopg2.connect(
        user = 'cac',
        password = 'cac',
        host = '127.0.0.1',
        port = 5432,
        database = 'cac'
    )
    cursor = connection.cursor()
    print('[+] Connected to PostgreSQL.')
    print('[*] Beginning transaction ...')
    cursor.execute('BEGIN TRANSACTION;')
    print('[+] Transaction started.')

    insert_statement = """INSERT INTO cards ("parentCardSet", "cardType", "content") VALUES (%s, %s, %s);"""
    for card_content in input_lines:
        card_content = card_content.strip()
        if len(card_content) > 0:
            record_params = (parent_cardset_id, cards_type, card_content)
            cursor.execute(insert_statement, record_params)
            print('[+] Inserted record with content "' + card_content + '"')
        else:
            print('[*] Empty line - skipping.')

    print('[*] Commiting dataset ...')
    cursor.execute('COMMIT;')
    print('[+] Commit complete.')
except (Exception, psycopg2.Error) as error:
    print('[-] An exception occurred during executing operation on PostgreSQL:', error)
    exit_status = 1
finally:
    if connection:
        cursor.close()
        connection.close()
        print('[+] Connection to PostgreSQL closed.')
    sys.exit(exit_status)