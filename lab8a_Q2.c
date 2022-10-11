//64050135 นิชาดา หวานรอบรู้
//Q1 = The max n is 20! = 2432902008176640000
#include  <stdio.h>
#include  <stdlib.h>
#include  <signal.h>
#include  <stdlib.h>
int main(){
    pid_t pid = fork();
    if(pid == 0){
        printf("child created\n");
        while(1)
        printf("this line should not be shown\n");
        exit(0);
    }else{
        sleep(0);
        kill(pid,SIGINT);
    }
    printf("child has been killed\n");
    return 0;
   
}
