extern _printf,_exit
global _main


section .data
format: db '%d', 10, 0
number4: dq 2
number3: dq 2
number1: dq 4
number0: dq 5

section .bss
number5: resq 1 
number2: resq 1 
number6: resq 1 

section .text
_main:
sub rsp,8
mov rax,[rel number3]
mov rdx,0
idiv qword [rel number4]
mov [rel number5],rax 
mov rax,[rel number0]
imul rax,[rel number1]
mov [rel number2],rax 
mov rax,[rel number2]
sub rax,[rel number5]
mov [rel number6],rax 

mov rdi,format
mov rsi,[rel number6]
mov rax,0
call _printf
xor rdi,rdi
call _exit
ret
