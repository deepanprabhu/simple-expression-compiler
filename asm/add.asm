extern _printf, _exit
global _main

section .data
    format: db "%d", 10, 0
section .text
_main:

    sub rsp,8
    mov rax,20
    mov rdi, format
    mov rsi, rax
    mov rax,0
    call _printf

    xor rdi,rdi
    call _exit
    ret