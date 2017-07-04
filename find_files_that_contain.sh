#!/bin/bash
# Find the files containg the keyword(s) under the current directory.
#
# Example:
#
#     ./find_files_that_contain.sh 1 2 3
#
keywords=$*
keywordsString=`echo ${keywords[@]}|tr ' ' '|'`

echo ${keywordsString}
for f in $(find . -name "*.java"); do
	matched=`egrep -wi --color  "$keywordsString" ${f}`
	if [[ $matched ]]; then
		echo ${f}
	fi
done


