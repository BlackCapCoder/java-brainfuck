Apparently there are people who willingly use Java, and so they teach me Java at school. I am going to have to deal with this for the next three years, so I might as well just take the carpal tunnel syndrome straight away and get used to it.

This is a full featured BrainFuck interpreter written in Java.

### Mandatory BrainFuck tutorial

BrainFuck uses an array of bytes for memory. It also has a pointer that is initially pointing at the first memory cell. There is a total of 8 operations in BrainFuck:

| Syntax | Description                                                                   |
|--------|-------------------------------------------------------------------------------|
| `>`    | Move the pointer one cell to the right                                        |
| `<`    | Move the pointer one cell to the left                                         |
| `+`    | Add one to the memory cell under the pointer                                  |
| `-`    | Subtract one from the memory cell under the pointer                           |
| `.`    | Read the memory cell under the pointer and print to STDOUT                    |
| `,`    | Read a single byte from STDIN and store it in memory cell under the pointer   |
| `[`    | If the memory cell under the pointer is `0`, jump past the matching bracket   |
| `]`    | If the memory cell under the pointer is not `0`, jump to the matching bracket |

All other characters are ignored.
