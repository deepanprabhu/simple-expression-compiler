extern _printf, _exit
section .data
    format db "%d", 10, 0
section .text
    global _main
    _main:
        sub rsp, 8
        mov rsi, 20
        mov rdi, format
        xor rax, rax
        call _printf
        mov rdi, 0
        call _exit