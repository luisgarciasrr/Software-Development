var delayInMilliseconds = 800;
var now = new Date().getTime();
var millisecondsToWait = 4000; /* i.e. 1 second */
var tiron=1;
var image1 = 0;
var image2 = 0;
var alp="";
var alp2="";
var col1,col2,ren1,ren2;
var act1,act2;
var pusher = new Array(2);
var turnp = 1;
var par_enc = 0;
var ap1=0,ap2=0;
a=new Array(8);
for (i=0; i<=7; i++) a[i]=new Array(8);
var conjunto =["abu_1","apu_1","ass_1","ayu_1","bam_1","ber_1","car_1","dal_1","dru_1","duf_1","fla_1","gat_1","gma_1","gor_1","hom_1","kru_1","len_1","lis_1","maf_1","mag_1","mar_1","mil_1","nel_1","ott_1","out_1","raf_1","ser_1","ski_1","tom_1","vie_1","wil_1","bar_1","abu_1","apu_1","ass_1","ayu_1","bam_1","ber_1","car_1","dal_1","dru_1","duf_1","fla_1","gat_1","gma_1","gor_1","hom_1","kru_1","len_1","lis_1","maf_1","mag_1","mar_1","mil_1","nel_1","ott_1","out_1","raf_1","ser_1","ski_1","tom_1","vie_1","wil_1","bar_1"];

b=new Array(8);
for (i=0; i<=7; i++) b[i]=new Array(8);

c=new Array(8);
for (i=0; i<=7; i++) c[i]=new Array(8);

function inicial()
{
    imagen=0;
    for(i=0; i<=7; i++)
       {
           document.write("<tr align='center'>");
           for(j=0; j<=7;j++)
               {
                   document.write("<td><img src='cuadro.jpg' onmouseover='rs("+j+","+i+","+imagen+")' onmouseout='rf("+j+","+i+","+imagen+")' onclick='tiro("+j+","+i+","+imagen+")' class='opa'></td>");
                   imagen++;
                   a[j][i]=0;
                   b[j][i]=0;
                   c[j][i] = 0;
               }
           document.write("<tr>")
       }
    seter();
}

function seter(){
    noimagen = 0;
    
    do{
        col=Math.round(Math.random()*7);
        ren=Math.round(Math.random()*7);
        if(b[ren][col] == 1){
        
       }
        else{
        b[ren][col] = 1;
        c[ren][col] = conjunto[noimagen];
        noimagen++;
        }
    }while(noimagen<=63);
}

function rs(col,ren,imagen)
{
   // alert(col+","+ren+","+imagen);
    if ((a[col][ren]==0)||(a[col][ren]==1))
        {
            document.images.item(imagen).src="mira.png";
        }
}

function rf(col,ren,imagen)
{
    //alert(col+","+ren+","+imagen);
    if ((a[col][ren]==0)||(a[col][ren]==1))
        {
            document.images.item(imagen).src="cuadro.jpg";
        }
}

function tiro(col, ren, imagen){
    document.alpha.status_show.value=""; 
    if((a[col][ren]!=0)&&(a[col][ren]!=1)){
                    document.alpha.status_show.value="Celda con tiro previo"; 
                    alp="";
               }
            else{
                if(tiron == 1){
                    act1 = 0;
                   if(a[col][ren]==0){
                                 alp = "";
                                    alp = c[col][ren] + ".jpg";
                                        document.images.item(imagen).src="images/simpson_1/" + alp;
                                        a[col][ren]=3;
                                       col1 = col;                 
                                       ren1 = ren;
                                    act1=1;
                                       tiron=2;
                       image1 = imagen;
                       pusher[0] = alp;
                                   }
                    
                            }
                
                else{
                    act2 = 0;
                    if(a[col][ren]==0){
                                 alp2 = "";
                                    alp2 = c[col][ren] + ".jpg";
                                        document.images.item(imagen).src="images/simpson_1/" + alp2;
                                        a[col][ren]=3;
                                        col2 = col;                 
                                        ren2 = ren;
                                        act2=1;
                                        tiron=1;
                                        image2 = imagen;
                                        //tiron=1;
                        pusher[1] = alp2;
                                   }
                    
                }
                  if(act1 == 1 && act2 == 1){
                            act1 =0; act2=0;
                            if(pusher[0] == pusher[1]){
                                document.alpha.status_show.style.background="green";
                                document.alpha.status_show.value="Las cartas seleccionadas son par.";
                                if(turnp == 1){
                                   ap1++;
                                    document.alpha.pairs_p1.value=ap1;
                                   }                                   
                                else{
                                    ap2++;
                                    document.alpha.pairs_p2.value=ap2;
                                }
                                par_enc++;
                               }
                            else{
                                if(turnp==1){
                                    document.alpha.turn_1.style.background="grey";
                                    document.alpha.pairs_p1.style.background="grey";
                                    turnp=2;
                                    document.alpha.turn_2.style.background="green";
                                    document.alpha.pairs_p2.style.background="green";
                                   }
                                else{
                                    document.alpha.turn_2.style.background="grey";
                                    document.alpha.pairs_p2.style.background="grey";
                                    turnp=1;
                                    document.alpha.turn_1.style.background="green";
                                    document.alpha.pairs_p1.style.background="green";
                                }
                                
                                document.alpha.status_show.style.background="red";
                                document.alpha.status_show.value="Las cartas seleccionadas no son par, cambio de jugador.";
                                //delay
                                setTimeout(function(){
                                    a[col1][ren1] = 0;
                                a[col2][ren2] = 0;
                                document.images.item(image1).src="cuadro.jpg";
                                document.images.item(image2).src="cuadro.jpg";
                                },delayInMilliseconds);
                                
                            }
                           }
            }
    

    if(par_enc == 32){
        
        if(ap1==ap2){
            window.location.href="draw.html";
        }
        else{
            if(ap1 > ap2){
            window.location.href="winer_p1.html";
        }
            else{
                window.location.href="winer_p2.html";
            }
            
        }
    }
}

