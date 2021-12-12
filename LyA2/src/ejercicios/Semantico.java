package ejercicios;
//Diego Manzo Avalos 18420461
//Jesus Morgado Marquez 18420469
//Gramatica LR #2

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
public class Semantico {
Stack<String> pilaSin=new Stack<String>();
Stack<String> pilaSem=new Stack<String>();
Scanner sc=new Scanner(System.in);
String codigo;
String entrada="";
String colum[]= {"id","int","float","char",",",";","+","-","*"
				,"/","(",")","=","$","P","Tipo","V","A","E","T","F"};
String EsReserv[]= {"int","float","char"};
char EsOper[]= {'+','-','*','/','=','(',')',',',';'};
String vecTbs[];
String msjer;
int Reng=0;
int Col=0;
int conid;
int tmc;
int fallSem;
int pos;
int postk;
boolean inc=false;
String tabSimbo[][]=new String[1][5];
int indR,indC;
String cadTp;
IntCodigo ic;

int TabSintac[][]=

//Edoid id  int float char   ,   ;   +   -   *   /   (   )   =   $   P   Tipo   V    A   E   T   F
{
 /*0*/  {7,  3,   4,   5,   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  1,    2,   -1,  6, -1, -1, -1},
 /*1*/  {-1,-1,  -1,  -1,   -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1,  -1,   -1, -1, -1, -1, -1},
 /*2*/  {8, -1,  -1,  -1,   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  -1,  -1,   -1, -1, -1, -1, -1},
 /*3*/  {103,-1, -1,  -1,   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  -1,  -1,   -1, -1, -1, -1, -1},
 /*4*/  {104,-1, -1,  -1,   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  -1,  -1,   -1, -1, -1, -1, -1},
 /*5*/  {105,-1, -1,  -1,   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  -1,  -1,   -1, -1, -1, -1, -1},
 /*6*/  {-1, -1, -1,  -1,   -1, -1, -1, -1, -1, -1, -1, -1, -1, 102, -1,  -1,   -1, -1, -1, -1, -1},
 /*7*/  {-1, -1, -1,  -1,   -1, -1, -1, -1, -1, -1, -1, -1,  9, -1,  -1,  -1,   -1, -1, -1, -1, -1},
 /*8*/  {-1, -1, -1,  -1,   11, 12, -1, -1, -1, -1, -1, -1, -1, -1,  -1,  -1,   10, -1, -1, -1, -1},
 /*9*/  {17, -1, -1,  -1,   -1, -1, -1, -1, -1, -1, 16, -1, -1, -1,  -1,  -1,   -1, -1, 13, 14, 15},
/*10*/  {-1, -1, -1,  -1,   -1, -1, -1, -1, -1, -1, -1, -1, -1, 101, -1,  -1,   -1, -1, -1, -1, -1},
/*11*/  {18, -1, -1,  -1,   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  -1,  -1,   -1, -1, -1, -1, -1},
/*12*/  {7,   3,  4,   5,   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  19,   2,   -1,  6, -1, -1, -1},
/*13*/  {-1, -1, -1,  -1,   -1, 20, 21, 22, -1, -1, -1, -1, -1, -1,  -1,  -1,   -1, -1, -1, -1, -1},
/*14*/  {-1, -1, -1,  -1,   -1,111,111,111, 23, 24, -1,111, -1, -1,  -1,  -1,   -1, -1, -1, -1, -1},
/*15*/  {-1, -1, -1,  -1,   -1,114,114,114,114,114, -1,114, -1, -1,  -1,  -1,   -1, -1, -1, -1, -1},
/*16*/  {17, -1, -1,  -1,   -1, -1, -1, -1, -1, -1, 16, -1, -1, -1,  -1,  -1,   -1, -1, 25, 14, 15},
/*17*/  {-1, -1, -1,  -1,   -1,116,116,116,116,116, -1,116, -1, -1,  -1,  -1,   -1, -1, -1, -1, -1},
/*18*/  {-1, -1, -1,  -1,   11, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1,  -1,    26, -1, -1, -1, -1},
/*19*/  {-1, -1, -1,  -1,   -1, -1, -1, -1, -1, -1, -1, -1, -1, 107, -1,  -1,   -1, -1, -1, -1, -1},
/*20*/  {-1, -1, -1,  -1,   -1, -1, -1, -1, -1, -1, -1, -1, -1, 108, -1,  -1,   -1, -1, -1, -1, -1},
/*21*/  {17, -1, -1,  -1,   -1, -1, -1, -1, -1, -1, 16, -1, -1, -1,  -1,  -1,   -1, -1, -1, 27, 15},
/*22*/  {17, -1, -1,  -1,   -1, -1, -1, -1, -1, -1, 16, -1, -1, -1,  -1,  -1,   -1, -1, -1, 28, 15},
/*23*/  {17, -1, -1,  -1,   -1, -1, -1, -1, -1, -1, 16, -1, -1, -1,  -1,  -1,   -1, -1, -1, -1, 29},
/*24*/  {17, -1, -1,  -1,   -1, -1, -1, -1, -1, -1, 16, -1, -1, -1,  -1,  -1,   -1, -1, -1, -1, 30},
/*25*/  {-1, -1, -1,  -1,   -1, -1, 21, 22, -1, -1, -1, 31, -1, -1,  -1,  -1,   -1, -1, -1, -1, -1},
/*26*/  {-1, -1, -1,  -1,   -1, -1, -1, -1, -1, -1, -1, -1, -1, 106, -1,  -1,   -1, -1, -1, -1, -1},
/*27*/  {-1, -1, -1,  -1,   -1,109,109,109, 23, 24, -1,109, -1, -1,  -1,  -1,   -1, -1, -1, -1, -1},
/*28*/  {-1, -1, -1,  -1,   -1,110,110,110, 23, 24, -1,110, -1, -1,  -1,  -1,   -1, -1, -1, -1, -1},
/*29*/  {-1, -1, -1,  -1,   -1,112,112,112,112,112, -1,112, -1, -1,  -1,  -1,   -1, -1, -1, -1, -1},
/*30*/  {-1, -1, -1,  -1,   -1,113,113,113,113,113, -1,113, -1, -1,  -1,  -1,   -1, -1, -1, -1, -1},
/*31*/  {-1, -1, -1,  -1,   -1,115,115,115,115,115, -1,115, -1, -1,  -1,  -1,   -1, -1, -1, -1, -1},
		};

					//    =     int(0)    float(1)   char(2)
String TabAsig[][]={/*int(0)*/ { "int",    "float",     "-1"},
					/*float(1)*/{"float",  "float",   "-1"},
					/*char(2)*/{ "-1",      "-1",     "char"}};

					     //+-*/ int(0) float(1) char(2)
String TabOper[][]={/*int(0)*/ {"int",  "float",    "-1"},
                 /*float(1)*/{ "float", "float",  "-1"},
                 /*char(2)*/{   "-1",    "-1",    "-1"}};

boolean repe;

//---------------------Constructor-----------------
public Semantico() {
	codigo="";
	repe=false;
	pilaSin.push("$");
	pilaSin.push("0");
	indR=indC=conid=tmc=0;
	cadTp="null";
	vecTbs=new String[5];
	msjer="";
	fallSem=0;
	pos=-1;
	postk=0;
	ic=new IntCodigo();
}

/*--------------------Metodos Principales-----------------*/
	public void Lectura () {
	do {
	System.out.println("<<<-------Bienvenido-------->>>");
	System.out.println("Ingresa la codificacion:");
	codigo=sc.nextLine();
	codigo+=" $";
	Lexico(codigo);
	Reinicio();
	System.out.println("¿Deseas ingresar un nuevo codigo?");
	System.out.println("Si / No :");
	entrada=sc.nextLine();
	}while(entrada.equals("Si") || entrada.equals("si") ||  entrada.equals("SI"));
	}
	public void Lexico(String codi) {
		StringTokenizer st=new StringTokenizer(codigo);
		String value="";
		while(st.hasMoreTokens() && Reng !=-1 && Reng!=100 && fallSem!=-2) {			
			value=st.nextToken();
			if(st.hasMoreTokens())
			pos++;
			ProcToken(value);
		}
		if(Reng!=-1 && fallSem!=-2) {
		System.out.println("<<<Codigo Ingresado Valido>>>");
		ic.showCode();
		}
		
	}
	//Procesar el token 
	public void ProcToken (String val) {
		
		String AuxCad="";
		if(EncReserv(val)) { //Es reservada, se envia directo
			IngNoterm(val);
			Sintactico(val);
			pos+=val.length();
			
			
		}else if (val.length()==1 && EncOper(val.charAt(0))){ //Es operador se envia directo
			IngNoterm(val);
			Sintactico(val);
			pos++;
			
			
		}else if (ident_id(val)) { //Es ids
			
			if(GuardTabSimb(val)) {
			IngDatos(cadTp,val,"id"+conid,"null","null");
			MatrizDinam(vecTbs);
			inc=true;
			}else
			inc=false;
			Sintactico("id"+conid);
			pos+=val.length();
			if(!inc)
			conid=tmc;
			if(inc)
			conid++;
			
			
		}else {  //Mixto ids operadores
			
			for(int i=0; i<val.length(); i++){
				if (Reng!=-1){
				if(EncOper(val.charAt(i))) {
					
				if(AuxCad.length()>0 && ident_id(AuxCad)) {  //identificador con operador
					
					if(GuardTabSimb(AuxCad)) {
					IngDatos(cadTp,AuxCad,"id"+conid,"null","null");
					MatrizDinam(vecTbs);
					inc=true;
					}else
					inc=false;
					Sintactico("id"+conid);
					pos+=AuxCad.length();
					Sintactico(val.charAt(i)+"");
					pos++;
					IngNoterm(val.charAt(i)+"");
					AuxCad="";
					if(!inc)
					conid=tmc;
					if(inc)
					conid++;
					
				}else if(AuxCad.length()>0) {  //No identificador y operador
					IngNoterm(val.charAt(i)+"");
					Sintactico(AuxCad);
					pos+=AuxCad.length();
					Sintactico(val.charAt(i)+"");
					pos++;
					
					AuxCad="";
					
				}else {
				IngNoterm(val.charAt(i)+"");
				Sintactico(val.charAt(i)+"");
				pos++;
				AuxCad="";
				}	
				}else {
					
					AuxCad+=val.charAt(i);	
					if(val.length()==1) {
						Sintactico(val);
						pos+=val.length();
					
					}else if(i==val.length()-1 && ident_id(AuxCad)) {
					if(GuardTabSimb(AuxCad)) {
					IngDatos(cadTp,AuxCad,"id"+conid,"null","null");
					MatrizDinam(vecTbs);
					inc=true;
					}else
					inc=false;
					Sintactico("id"+conid);
					pos+=AuxCad.length();
				   if(!inc)
				   conid=tmc;
				   if(inc)
				   conid++;
				   
					}else if(i==val.length()-1) {
						Sintactico(AuxCad);
						pos+=AuxCad.length();
						
					}
				}
				
			}else
			break; //Romper el ciclo for
		}
		}
		
	}
	public void Sintactico(String token){
		if(Reng!=-1 && fallSem!=-2) {
		Col=posColum(token);
		 int RenT=0;
		if(Col==-1){
			ic.showCode();
			System.out.println("Error Lexico: Token Invalido-->"+token);
			Reng=-1;
		}else {
			do {
			Reng=Integer.parseInt(pilaSin.peek());
			RenT=TabSintac[Reng][Col];
			ModifPil(RenT,token);
			if(RenT==-1)
			{
			locError(Reng);
			ic.showCode();
			System.out.println("Error Sintactico: Estructura incompleta-->Se esperaba "+msjer);
		    Reng=-1;	
		    repe=false;
			}
			
			}while(repe==true);
		}
		}
	}
	
/*--------------------Metodos Auxiliares-----------------*/
//Metodo para obtener la posicion de la Columna de la tabla
public int posColum(String dat) {
	for(int i=0; i<colum.length; i++) {
		if(i==0) {
	if(dat.length()>2 && dat.substring(0,2).equals("id") && Esnumero(dat.substring(2,dat.length())))
			return i;
		}else
		if(colum[i].equals(dat)) 
			return i;	
	}
	return -1;
}
	//Metodo para verificar si es un Id
	public boolean ident_id(String dato) {
		char c=' ';
		int Vasc=0;
		int cont=0;
		for(int i=0; i<dato.length(); i++) {
			c=dato.charAt(i);
			Vasc=(int)c;
			if(i==0 && (Vasc>=48 && Vasc<=57))
				return false;
			else if((Vasc>=48 && Vasc<=57) || (Vasc>=65 && Vasc<=90) || (Vasc>=97 && Vasc<=122))
				cont++;
		}
		if(cont==dato.length())
		return true;
		
		return false;
	}
	//Metodo para ingresar Valores a la pila
	public void ModifPil(int Rt,String tk) { //Buscar Estado
		String v[]; //vector para datos
		if(Rt!=-1) {
			//Producciones
			int R=0;
			if(Rt>99) {
				repe=true;
				switch(Rt) {
				case 100:
					//P'-->P   Se acepta el codigo
					   Reng=100;
					   repe=false;
					   ic.GenCodigo(100);
				
				break;
				case 101:
					//P-->Tipo id V
					Sacar(6);
					R=Integer.parseInt(pilaSin.peek());
					pilaSin.push("P");
					pilaSin.push(TabSintac[R][posColum("P")]+"");
					
				break;
				case 102:
					//P-->A
					Sacar(2);
					R=Integer.parseInt(pilaSin.peek());
					pilaSin.push("P");
					pilaSin.push(TabSintac[R][posColum("P")]+"");
				break;
				case 103:
					//Tipo-->int					
					Sacar(2);					
					R=Integer.parseInt(pilaSin.peek());
					pilaSin.push("Tipo");
					pilaSin.push(TabSintac[R][posColum("Tipo")]+"");
				break;
				case 104:
					//Tipo-->float
					Sacar(2);
					R=Integer.parseInt(pilaSin.peek());
					pilaSin.push("Tipo");
					pilaSin.push(TabSintac[R][posColum("Tipo")]+"");
				break;
				case 105:
					//Tipo-->char
					Sacar(2);
					R=Integer.parseInt(pilaSin.peek());
					pilaSin.push("Tipo");
					pilaSin.push(TabSintac[R][posColum("Tipo")]+"");
				break;
				case 106:
					//V--> , id V
					Sacar(6);
					R=Integer.parseInt(pilaSin.peek());
					pilaSin.push("V");
					pilaSin.push(TabSintac[R][posColum("V")]+"");
				break;
				case 107:
					//V--> ; P
					Sacar(4);
					R=Integer.parseInt(pilaSin.peek());
					pilaSin.push("V");
					pilaSin.push(TabSintac[R][posColum("V")]+"");
					ic.GenCodigo(107);
				break;
				case 108:
					//A-->id=E;
					
					Sacar(8);
					R=Integer.parseInt(pilaSin.peek());
					pilaSin.push("A");
					pilaSin.push(TabSintac[R][posColum("A")]+"");
					OpilSem(108);
					
				break;
				case 109:
					//E-->E + T
					Sacar(6);
					R=Integer.parseInt(pilaSin.peek());
					pilaSin.push("E");
					pilaSin.push(TabSintac[R][posColum("E")]+"");
					OpilSem(109);
					ic.GenCodigo(109);
					
					
				break;
				case 110:
					//E-->E-T
					Sacar(6);
					R=Integer.parseInt(pilaSin.peek());
					pilaSin.push("E");
					pilaSin.push(TabSintac[R][posColum("E")]+"");
					OpilSem(110);
					ic.GenCodigo(110);
					
				break;
				case 111:
					//E-->T
					Sacar(2);
					R=Integer.parseInt(pilaSin.peek());
					pilaSin.push("E");
					pilaSin.push(TabSintac[R][posColum("E")]+"");
				break;
				case 112:
					//T-->T*F
					Sacar(6);
					R=Integer.parseInt(pilaSin.peek());
					pilaSin.push("T");
					pilaSin.push(TabSintac[R][posColum("T")]+"");
					OpilSem(112);
					ic.GenCodigo(112);
					
				break;
				case 113:
					//T-->T/F
					Sacar(6);
					R=Integer.parseInt(pilaSin.peek());
					pilaSin.push("T");
					pilaSin.push(TabSintac[R][posColum("T")]+"");
					OpilSem(113);
					ic.GenCodigo(113);
				break;
				case 114:
					//T-->F
					Sacar(2);
					R=Integer.parseInt(pilaSin.peek());
					pilaSin.push("T");
					pilaSin.push(TabSintac[R][posColum("T")]+"");
				break;
				case 115:
					//F-->(E)
					Sacar(6);
					R=Integer.parseInt(pilaSin.peek());
					pilaSin.push("F");
					pilaSin.push(TabSintac[R][posColum("F")]+"");
				break;
				case 116:
					//F-->id
					postk=1;					
					Sacar(2);
					v=busqueda(ic.id);
					ic.id=v[1];
					R=Integer.parseInt(pilaSin.peek());
					pilaSin.push("F");
					pilaSin.push(TabSintac[R][posColum("F")]+"");
					ic.GenCodigo(116);
					
				break;
				}
			
			
			
			//Ingresar Estados
			}else{
				repe=false;
				if(colum[Col].equals("id")) {
					pilaSin.push(tk);
					v=busqueda(tk);
					ic.id=v[1];
					ic.Declarar(Col);
					
				}else {
					pilaSin.push(colum[Col]);
					ic.Declarar(Col);
				}
					
				if(colum[Col].equals("id")) { //Control errores semanticos declaracion
					String val[];
					val=busqueda(tk);
					//Obtuve los datos
					if(val[0].equals("null")) {
						ic.showCode();
						System.out.println("Error Semantico: Variable-->"+val[1]+" no definida");
						Reng=-1;
						fallSem=-2;
					}else if(buscaDoble(val[1])>1) {
						ic.showCode();
					System.out.println("Error Semantico: Doble declacacion-->"+val[1]);
					Reng=-1;
					fallSem=-2;
					}else
					pilaSem.push(val[0]);
					
				}
					
				pilaSin.push(Rt+"");
			}
		}
	}
	//Realiza Push N veces a la pila
	public void Sacar(int vces) {
		for(int i=0; i<vces; i++) {
			if(i!=0 && i==postk) //Obtener token para codigo intermedio
			ic.id=pilaSin.peek();
			
			if(pilaSin.isEmpty()==false)
			pilaSin.pop();
		}
		postk=0;
	}
	//Limpia la pila
	public void Reinicio() {
		Col=Reng=indR=indC=conid=tmc=0;
		repe=false;
		inc=false;
		fallSem=0;
		tabSimbo=new String[1][5];
		pilaSin.clear();
		pilaSin.push("$");
		pilaSin.push("0");
		pilaSem.clear();
		cadTp="null";
		pos=-1;
		ic.cdi="";
		ic.tpd="null";
		ic.varf="";
		ic.id="";
		ic.cvar=0;
	}
	
	//Metodo para identificar la reservada
	public boolean EncReserv(String palRes) {
		for(int i=0; i<EsReserv.length; i++)
			if(palRes.equals(EsReserv[i]))
				return true;
		return false;	
	}
	public boolean EncOper(char oper) {
		for(int i=0; i<EsOper.length; i++)
			if(oper==EsOper[i])
				return true;
		return false;
	}
   //Metodo modificar una matriz a dinamica
	public void MatrizDinam(String dat[]){
		
		for(int i=0; i<dat.length; i++) {
			try {
			tabSimbo[indR][indC++]=dat[i];
			}catch(ArrayIndexOutOfBoundsException e) {
				 String Matemp[][]= new String[indR+1][5];
				 for(int r=0; r<tabSimbo.length; r++) 
					 for(int c=0; c<tabSimbo[0].length; c++) 
						 Matemp[r][c]=tabSimbo[r][c];
					 
				 for(int f=0; f<dat.length; f++)
					 Matemp[indR][f]=dat[f];
				 
				 tabSimbo=Matemp;
				 i=dat.length;
			}			
		}
		indR++;
		indC=0;	
	}
	//Metodo para ingresar datos al vector auxiliar
	public void IngDatos(String tpo,String nm,String com,String val,String ref) {
		vecTbs[0]=tpo;
		vecTbs[1]=nm;
		vecTbs[2]=com;
		vecTbs[3]=val;
		vecTbs[4]=ref;

	}
//Metodo Temporal Mostrar el contenido de la matriz
	public void MostMat() {
		for(int r=0; r<tabSimbo.length; r++) {
			for(int c=0; c<tabSimbo[0].length; c++) {
				System.out.print(tabSimbo[r][c]+" ");
			}
			System.out.println();
		}
	}
	public void IngNoterm(String  nt) {
		switch(nt) {
		case "int":   //ingresado int
			cadTp="int";
		break;
		case "float":   //ingresado float
			cadTp="float";
		break;
		case "char":   //ingresado char
			cadTp="char";
		break;
		case ";":   //ingresado ;
			cadTp="null";
		break;
		}
	}
	//Identifica el error sintactico
	public void locError(int reg) {
		switch (reg) {
		
		case 0:
			msjer="Declaracion/Asignacion-->Pos:"+pos;
			break;
		case 1:
			msjer="Finalizador-->Pos:"+pos;
			break;
		case 2:
			msjer="id-->Pos:"+pos;
			break;
		case 3:
			msjer="Declaración int-->Pos:"+pos;
			break;
		case 4:
			msjer="Declaración float-->Pos:"+pos;
			break;
		case 5:
			msjer="Declaración char-->Pos:"+pos;
			break;
		case 6:
			msjer="Asignacion/Declaracion-->Pos:"+pos;
			break;
		case 7:
			msjer="Asignacion-->Pos:"+pos;
			break;
		case 8:
			msjer=", | ;  -->Pos:"+pos;
			break;
		case 9:
			msjer="id | ()  -->Pos:"+pos;
			break;
		case 10:
			msjer="Declaracion/Asignacion-->Pos:"+pos;
			break;
		case 11:
			msjer="id -->Pos:"+pos;
			break;
		case 12:
			msjer="Asignacion/Declaracion-->Pos:"+pos;
			break;
		case 13:
			msjer="+ | - | ;  -->Pos:"+pos;
			break;
		case 14:
			msjer="Expresion/Operador-->Pos:"+pos;
			break;
		case 15:
			msjer="Expresion/Operador-->Pos:"+pos;
			break;
		case 16:
			msjer="id | () -->Pos:"+pos;
			break;
		case 17:
			msjer="id | asignacion-->Pos:"+pos;
			break;
		case 18:
			msjer=", id | ;  -->Pos:"+pos;
			break;
		case 19:
			msjer=";  -->Pos:"+pos;
			break;
		case 20:
			msjer="Asignacion-->Pos:"+pos;
			break;
		case 21:
			msjer="id | Expresion -->Pos:"+pos;
			break;
		case 22:
			msjer="id | Expresion -->Pos:"+pos;
			break;
		case 23:
			msjer="id | Expresion -->Pos:"+pos;
			break;
		case 24:
			msjer="id | Expresion -->Pos:"+pos;
			break;
		case 25:
			msjer="Operador + | -  -->Pos:"+pos;
			break;
		case 26:
			msjer=", id  -->Pos:"+pos;
			break;
		case 27:
			msjer="Operacion +|*|/  -->Pos:"+pos;
			break;
		case 28:
			msjer="Operacion -|*|/  -->Pos:"+pos;
			break;
		case 29:
			msjer="Operacion Multiplicacion-->Pos:"+pos;
			break;
		case 30:
			msjer="Operacion Division-->Pos:"+pos;
			break;
		case 31:
			msjer="Expresion-->Pos:"+pos;
			break;
		}
	}
	
	//Identificar si es numero
	public boolean Esnumero(String numcd) {
		try {
			Integer.parseInt(numcd);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}	
	}
	//Encuentra las dobles declaraciones
	public int buscaDoble(String var) {
		int cont=0;
		for(int r=0; r<tabSimbo.length; r++)
			if(tabSimbo[r][1].equals(var))
				cont++;
		return cont;
	}
//buscamos en la tabla de simbolos los datos del id 
	public String[] busqueda(String id) {
		String datos[]=new String[5];
		for(int r=0; r<tabSimbo.length; r++) {
			if(tabSimbo[r][2].equals(id)) {
				for(int i=0; i<datos.length; i++)
					datos[i]=tabSimbo[r][i];
					return datos;
			}
		}
		
		return null;
	}
	//Modificacion a la pila Semantica
	public void OpilSem(int rv) {
		String vec[]=new String[2];
		if(rv!=108) { //Operaciones 
			vec[0]=pilaSem.pop();
			vec[1]=pilaSem.pop();
			pilaSem.push(Map(vec,0));
			if(pilaSem.peek().equals("-1")) {
				switch(rv) {
				case 109:
					ic.showCode();
				System.out.println("Error Semantico: Incompatibilidad de Operandos-->"+vec[1]+"+"+vec[0]);
				break;
				case 110:
					ic.showCode();
				System.out.println("Error Semantico: Incompatibilidad de Operandos-->"+vec[1]+"-"+vec[0]);
				break;
				case 112:
					ic.showCode();
				System.out.println("Error Semantico: Incompatibilidad de Operandos-->"+vec[1]+"*"+vec[0]);
				break;
				case 113:
					ic.showCode();
				System.out.println("Error Semantico: Incompatibilidad de Operandos-->"+vec[1]+"/"+vec[0]);
				break;
				}
				Reng=-1;
				fallSem=-2;
				
			}
		}else{ //Asignacion 
			vec[0]=pilaSem.pop();
			vec[1]=pilaSem.pop();
			pilaSem.push(Map(vec,1));
			if(pilaSem.peek().equals("-1")) {
				ic.showCode();
		System.out.println("Error Semantico: Asignacion Incompatible-->"+vec[1]+"="+vec[0]);
		Reng=-1;
		fallSem=-2;
			}
		}
	}
	//Realizamos el mapeo de los datos
	public String Map(String v[],int nv) {
		int p[]=new int[2];
		String cdr;
		String vec[]= {"int","float","char"};
		for(int i=0; i<2; i++)
			for(int s=0; s<vec.length; s++)
				if(vec[s].equals(v[i]))
					p[i]=s;
		if(nv==0)
			cdr=TabOper[p[1]][p[0]];
		else
			cdr=TabAsig[p[1]][p[0]];
		
		return cdr;
	}
	//Valida el guardado de ids en la tabla de simbolos
	public boolean GuardTabSimb(String var) {
		if(tabSimbo[0][0]!=null) {
		for(int r=0; r<tabSimbo.length; r++)
			if(tabSimbo[r][1].equals(var) && cadTp.equals("null")) {
				tmc=conid;
				conid=r;
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Semantico sm=new Semantico();
		sm.Lectura();
		
		
		
	}

}
