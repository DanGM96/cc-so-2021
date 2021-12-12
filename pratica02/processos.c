#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>

// 1. Incluindo o processo-pai inicial, quantos processos são criados pelo programa do código-fonte abaixo?

int main() {
    int i;
    printf("\n");
    for (i = 0; i < 4; i++) {
        fork();
    }
    //printf("ppID: %d\n", getppid());
    printf("pID: %d\n", getpid());
    return 0;
}
