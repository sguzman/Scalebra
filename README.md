# Scalebra

## A snake clone

### Summary
Scalebra is your basic snake clone. It's a portmanteau of Scala and Snake
in Spanish.

### Description
The goal of this game is the same as any other snake clone; get as big as
feasible possible. This means swallowing enough food to complete blot out
the entire window.

### Features
There tends to be some wiggle room into what exactly constitutes a snake
game, so I want jot down how this particular clone handles
#### Visual
##### Environment
- The window is discretized into 10-by-10 blocks
- The snake head and each of its body parts can only appear in blocks
- The borders of the window wrap around (if you go all the way up, you'll appear below)
##### Food
- The food piece appears as a white 10-by-10 block
- It can randomly appear in any free space
##### Snake
- Every time the head of the snake runs into food, it will increase its tail size by 1
- Every successive tail piece will be a different color