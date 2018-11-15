# Caesar's Cipher and Deciper

a programmatic implementation of Caesar (De)Cipher consisting of two parts each focused on a main function:

encipher(s, n) and decipher(s)

# encipher(s, n)

This function receives a string and a number and produces another string with each character of the string moved by n steps of the english alphabet.

Example: encipher("a",1) would produce b, encipher("x",3) would produce a.

# decipher(s)

This function deciphers a previously enciphered string, without however knowing the number of steps with which the string was enciphered. The number of steps must be deduced programmatically and then applied to the enciphered string to get the original text.
