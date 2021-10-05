import csv
import json
from collections import defaultdict

columns = defaultdict(list) # each value in each column is appended to a list

# with open('/Users/Will/Desktop/Stocks in the Dow Jones Industrial Average.csv') as f:
#     reader = csv.DictReader(f) # read rows into a dictionary format
#     for row in reader: # read a row as {column1: value1, column2: value2,...}
#         for (k,v) in row.items(): # go over each column name and value
#             columns[k].append(v) # append the value into the appropriate list
#                                  # based on column name k

# print(json.dumps(columns['Symbol']))
# print(json.dumps(columns['Description']))

# with open('/Users/Will/Desktop/constituents_csv.csv') as f:
#     reader = csv.DictReader(f) # read rows into a dictionary format
#     for row in reader: # read a row as {column1: value1, column2: value2,...}
#         for (k,v) in row.items(): # go over each column name and value
#             columns[k].append(v) # append the value into the appropriate list
#                                  # based on column name k

# print(json.dumps(columns['Symbol']))
# print(json.dumps(columns['Name']))

# with open('/Users/Will/Desktop/nasdaq-100-index-10-04-2021.csv') as f:
#     reader = csv.DictReader(f) # read rows into a dictionary format
#     for row in reader: # read a row as {column1: value1, column2: value2,...}
#         for (k,v) in row.items(): # go over each column name and value
#             columns[k].append(v) # append the value into the appropriate list
#                                  # based on column name k

# print(json.dumps(columns['Symbol']))
# print(json.dumps(columns['Name']))
