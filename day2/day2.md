## Part 1

Only numbers of even length can be invalid

An invalid number can be found, if the last digit of the first half the number can be incremented in the id range, and the second half is less than the first half, then an inalid id exists. If it cannot be incremented, we need to check the end of the range to see if the invalid id would exist


ex. 1300-1450

1300 can be incremented to 1400 since 1400 < 1450
this means that 1313 exists since 00 < 13

we can then go to 1400
1400 cannot be incremented to 1500 since 1500 > 1450
we can take the first half (14) and duplicated it for 1414.
1414 is valid since 1414 < 1450

This means we have two invalid IDs: 1313 and 1414

## Part 2

This is going to be very similar to the first part. We will cut the number in half again, and if not sequence is found, we will remove a character from the first half and check if the full string can be made as a sequence of the substring. We will repeat until we hit just 2 characters. We will now also check odd length numbers.
