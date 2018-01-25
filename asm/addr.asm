extern _printf, _exit
global _main

section .data
    format: db "%d", 10, 0
    number1: dq 1
    number2: dq 2
section .text
_main:

    sub rsp,8
    mov rax,[rel number1]
    add rax,[rel number2]
    mov rdi, format
    mov rsi, rax
    mov rax,0
    call _printf

    xor rdi,rdi
    call _exit
    ret