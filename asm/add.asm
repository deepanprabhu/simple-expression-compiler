extern printf, exit
section .data
    format db "%d", 10, 0
section .text
    global main
    main:
        sub rsp, 8
        mov rsi, 10
        mov rdi, format
        xor rax, rax
        call printf
        mov rdi, 0
        call exit