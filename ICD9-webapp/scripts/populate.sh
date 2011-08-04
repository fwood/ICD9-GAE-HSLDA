#!/bin/bash
# the location of the ICD9 csv file and the url need to be customized
# awk -F"," {'print $1 "," $2;'} ../../ICD9-Code-Database/CMS29_DESC_LONG_SHORT_DX.csv | awk '{gsub(/\"/,"");print}' | awk -F"," {'print "curl -i -X PUT -H '\''Content-Type: text/plain'\'' -d \"" $2 "\" http://localhost:8888/rest/icd9/"$1;'} > /tmp/commands
awk -F"," {'print $1 "," $2;'} ../../ICD9-Code-Database/CMS29_DESC_LONG_SHORT_DX.csv | awk '{gsub(/\"/,"");print}' | awk -F"," {'print "curl -i -X PUT -H '\''Content-Type: text/plain'\'' -d \"" $2 "\"  http://icd9dict.appspot.com/rest/icd9/"$1;'} > /tmp/commands
chmod 755 /tmp/commands
/tmp/commands
rm /tmp/commands
