# Testing repeat until
# Missing colon repeat until test
# Correct syntax

proc main ():
	int num = 0
	repeat
		write(num)
		num = num + 1
	until(num < 5).
.
