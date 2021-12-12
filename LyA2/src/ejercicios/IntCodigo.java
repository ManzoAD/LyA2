package ejercicios;
//Diego Manzo Avalos 18420461
//Jesus Morgado Marquez 18420469
//Gramatica LR #2
public class IntCodigo {
String tpd;    // Tipo de cadena
String cdi;   //  Codigo
String varf; //   Asig final
String id; //     id
int cvar; //      contador variables
	public IntCodigo() {
		tpd="null";
		cdi="";
		varf="";
		id="";
		cvar=0;
	}                    //string edo
	public void GenCodigo(int edo ) {
		switch(edo) {
		case 100:
			//Asignacion Final
			cdi+=(varf+"="+"var"+cvar+";");
		break;
		case 103:
			//Tipo-->int
			tpd="int";
			cdi+=(tpd+" "+id+";"+"\n");
		break;
		case 104:
			//Tipo-->float
			tpd="float";
			cdi+=(tpd+" "+id+";"+"\n");
		break;
		case 105:
			//Tipo-->char
			tpd="char";
			cdi+=(tpd+" "+id+";"+"\n");
		break;
		case 106:
			//V--> , id V
			if(tpd.compareTo("null")!=0)
			cdi+=(tpd+" "+id+";"+"\n");
		break;
		case 107:
			//V--> ; P
			tpd="null";
		break;
		case 109:
		//E-->E + T
			cdi+=("var"+(cvar-1)+"="+"var"+(cvar-1)+"+"+"var"+cvar+";\n");
			cvar--;
		break;
		case 110:
			//E-->E-T
			cdi+=("var"+(cvar-1)+"="+"var"+(cvar-1)+"-"+"var"+cvar+";\n");
			cvar--;
		break;
		case 112:
			//T-->T*F
			cdi+=("var"+(cvar-1)+"="+"var"+(cvar-1)+"*"+"var"+cvar+";\n");
			cvar--;
		break;
		case 113:
			//T-->T/F
			cdi+=("var"+(cvar-1)+"="+"var"+(cvar-1)+"/"+"var"+cvar+";\n");
			cvar--;
		break;
		case 116:
			//F-->id
			cvar++;
			cdi+=("var"+cvar+"="+id+";\n");
			
		break;
		}
	}
	public void Declarar(int edo) { //Declaracion codigo intermedio
		switch (edo) {
		case 0:
			//id
			if(tpd.compareTo("null")!=0)
			cdi+=(id+";"+"\n");
		break;
		case 1:
			//int
			tpd="int";
			cdi+="int ";
		break;
		case 2:
			//float
			tpd="float";
			cdi+="float ";
		break;
		case 3:
			//char
			tpd="char";
			cdi+="char ";
		break;
		case 4:
			// ,
			cdi+=(tpd+" ");
		break;
		case 5:
			// ;
			tpd="null";
		break;
		case 12:
			// =
			varf=id;
			//cdi+=(varf+"=");
		break;
		}
	}
	public void showCode() {
		System.out.println("\n<<<-------Codigo Intermedio------->>>");
		System.out.println(cdi);
		System.out.println("<<<-------Fin Codigo Intermedio--->>>\n");
	}
	public static void main(String[] args) {

	}

}
