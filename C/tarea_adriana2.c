#include <conio.h>
#include <stdio.h>

char num1[40],num2[40];
int nulos, nulos2;


void capturar_datos(){	
	printf("RECUERDA: Los numeros deben ir separados por un ESPACIO.\n Al terminar de ingresar cada numero presiona ENTER\n");
	printf("Ingresa el primer numero: ");
	scanf(" %[^\n]s",num1);
	int i;
	int recorrido=0;
	for(i=0;i<=39;i++){
		if(num1[i] == ' '|| num1[i] == '\0'){
			nulos++;	
		}
		
		else{
			num1[recorrido] = num1[i];
			recorrido++;
		}
	}
	
	printf("Ingresa el segundo numero: ");
	scanf(" %[^\n]s",num2);
	
	int recorrido2=0;
	for(i=0;i<=39;i++){
		if(num2[i] == ' '|| num2[i]=='\0'){
			nulos2++;		
		}
	
		else{
			num2[recorrido2] = num2[i];
			recorrido2++;
		}
	}
	
}

void resultado(){
	int total[41];
	int lr1,lr2;
	
	lr1 = 40- nulos;
	lr2 = 40 - nulos2;
	
	int d1, d2, d3, i, to, extra=0,real;
	if(lr1 == lr2){
		for(i=lr1-1;i>=0;i--){
				d1 = num1[i] - 48;
				d2 = num2[i] - 48;
				to = d1 + d2 + extra;
				if(i == 0){
					total[i] = d1 + d2 + extra;
				}
				
				else{
					if(to > 9){
					extra = 1;
					real = to-10;
						total[i] = real;	
					}
					
					else{
						extra = 0;
						total[i]= to;
					}
				}				
		}
		for(i = 0; i < lr1; i++ )
				printf( "%d", total[ i ] );
	}
	
	if(lr1 > lr2){
		for(i=lr1-1;i>=0;i--){
			d1 = num1[i] - 48;
			if(lr2 == 0){
				d2 = 0;
			}
			
			else{
				d2 = num2[lr2-1]- 48;
				lr2--;	
			}
			
			
			to = d1 + d2 + extra;
			if(i == 0){
				total[i] = d1 + d2 + extra;
			}
			else{
				if(to > 9){
					extra = 1;
					real = to-10;
						total[i] = real;	
					}
					
					else{
						extra = 0;
						total[i]= to;
					}
			}	
		}
		for(i = 0; i < lr1; i++ )
				printf( "%d", total[ i ] );
	}
	
	else{
		for(i=lr2-1;i>=0;i--){
			d2 = num2[i] - 48;
			if(lr1 == 0){
				d1 = 0;
			}
			
			else{
				d1 = num1[lr1-1]- 48;
				lr1--;	
			}
			
			to = d1 + d2 + extra;
			if(i == 0){
				total[i] = d1 + d2 + extra;
			}
			else{
				if(to > 9){
					extra = 1;
					real = to-10;
						total[i] = real;	
					}
					
					else{
						extra = 0;
						total[i]= to;
					}
			}	
		}
		for(i = 0; i < lr2; i++ )
				printf( "%d", total[ i ] );
	}
}


int main(int argc, char *argv[]){
	capturar_datos();
	resultado();
	return 0;
}
