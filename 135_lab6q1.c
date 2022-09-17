#include<pthread.h>
#include<stdio.h>
#include<stdlib.h>

int csum = 0;
int msum = 0;
void *runner(void *param);

int main(int argc, char *argv[]){
    pthread_t tid;
    pthread_attr_t attr;
    pthread_attr_init(&attr);
    pthread_create(&tid, &attr, runner, argv[1]);
    pthread_join(tid, NULL);
    int upper = atoi(argv[1]);
    int i;
    //int msum = 0;
    if(upper > 0){
        for(i = 0; i <= upper; i++)
            msum += i;
    }
    printf("csum  = %d\n",csum );
    printf("msum  = %d\n",msum );
    printf("csum - msum = %d\n",csum - msum);
    //printf("sum = %d\n",sum);
    return 0;
}
void *runner(void *param){
    int upper = atoi(param);
    int i;

    //int csum = 0;
    if(upper > 0){
        for(i = 0; i<= 2*upper; i++)
            csum += i;
    }
    pthread_exit(0);
}
//2.5  มี2แบบ คือ ถ้าแม่สร็จก่อนลูกเป็นลบ แต่ถ้าลูกเสร็จก่อนแม่เป็นบวก
