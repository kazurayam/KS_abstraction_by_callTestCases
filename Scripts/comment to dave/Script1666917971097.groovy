
You should start with studying the specification of Email messages.

Refer to

[Internet Message Format](https://www.rfc-editor.org/rfc/rfc2822#section-2.1)
	
>Messages are divided into lines of characters.  A line is a series of
characters that is delimited with the two characters carriage-return
and line-feed; that is, the carriage return (CR) character (ASCII
value 13) followed immediately by the line feed (LF) character (ASCII
value 10).  (The carriage-return/line-feed pair is usually written in
this document as "CRLF".)

Here the doc mentions CRLF (0x0D 0x0A in hex) should be used in Email messages on the fly.

----

You must be careful that a "new line" character **in files** is heavily OS-dependent.

Mac wants a new line to be a single LF (0x0A). Therefore any text editors translates 0x0D 0x0A into 0x0a.

Linux want the same as Mac.

Windows wants (perhaps) a new line to be 2 bytes of CRLF. Text editors translates 0x0A into 0x0D 0x0A.

Also, Git has feature that translate new line characters in all text files into 0x0A (Unix-style) when you commit changes into git repository even on Windows.

There is a secrete in Java also. The following code:
```
System.out.println("\n");
```
This line writes a 0x0A on Mac, but it will, though I haven't tested it, writes "0x0D 0x0A" on Windows. Java checks the type of OS and switches the binary representation of "\n".

... In Networking, "new line" requires special attention. If you are not very careful, you would get into trouble.

-----

You have created many .eml files already. 
Are you aware if these have 2 consecutive CRLFs or 2 consecutive 0x0A as Separators of Email Header and Body?

Probably you are not aware.


----

Short advice to @Dave_Evers

**You shouldn't make .eml files at all.**

You should not save the raw bytes of Email message into local a file to consume afterward.

