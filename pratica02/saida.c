#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

// 2. Considerando o código-fonte abaixo, explique qual a saída apontada nas linhas X e Y, respectivamente.

#define SIZE 5

int nums[SIZE] = {0, 1, 2, 3, 4};
int main() {
    int i;
    pid_t pid;
    pid = fork();
    if (pid == 0) {
        for (i = 0; i < SIZE; i++) {
            nums[i] *= -i;
            printf("\tCHILD: % d ", nums[i]); /* LINHA X */
        }
    } else if (pid > 0) {
        wait(NULL);
        for (i = 0; i < SIZE; i++) {
            printf("\tPARENT: % d ", nums[i]); /* LINHA Y */
        }
    }
    printf("\n");
    return 0;
}
