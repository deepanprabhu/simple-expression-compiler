
extern _printf,_exit
global _main


section .data
format: db '%d', 10, 0
number3: dq 5
number1: dq 3
number0: dq 2

section .bss
number2: resq 1
number4: resq 1

section .text
_main:
sub rsp,8
mov rax,[rel number0]
imul rax,[rel number1]
mov [rel number2],rax
mov rax,[rel number3]
add rax,[rel number2]
mov [rel number4],rax

mov rdi,format
mov rsi,[rel number4]
mov rax,0
call _printf
xor rdi,rdi
call _exit
ret
