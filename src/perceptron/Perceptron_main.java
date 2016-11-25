package perceptron;

public class Perceptron_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double nu[] = {0.35, 0.2};
		Perceptron_lib plib = new Perceptron_lib(2, nu, 0.01, 0.5);
	
//AND演算だけだとつまらないので、色々な演算をやってみた。
		
//OR演算
//		double input[][] = { {0,0},{0,1},{1,0},{1,1}};
//		double output[] = { 0, 1, 1, 1};
		
//AND演算
		double input[][] = { {0,0}, {0,1}, {1,0}, {1,1}};
		double output[] = { 0, 0, 0, 1};

//P⇒Q 
//		double input[][] = { {0,0}, {0,1}, {1,0}, {1,1}};
//		double output[] = { 1, 1, 0, 1};

//	P XOR Q  
//		double input[][] = { {0,0}, {0,1}, {1,0}, {1,1}};
//		double output[] = { 0, 1, 1, 0};
	
//P NOR Q
//		double input[][] = { {0,0}, {0,1}, {1,0}, {1,1}};
//		double output[] = { 1, 0, 0, 0};

//P NAND Q
//		double input[][] = { {0,0}, {0,1}, {1,0}, {1,1}};
//		double output[] = { 1, 1, 1, 0};

//P≡Q
//		double input[][] = { {0,0}, {0,1}, {1,0}, {1,1}};
//		double output[] = { 1, 0, 0, 1};
		
		
		int index,k=0;
		for(int i = 0; i < 10000; i++){
			index = (int)(Math.random()*4);
			plib.getParameter(input[index], output[index]);
			System.out.println("index : "+i+"nu = "+nu[0]+", "+nu[1]);
			
			if(plib.getOutput(input[0])==output[0] && plib.getOutput(input[1])==output[1] &&
					plib.getOutput(input[2])==output[2] && plib.getOutput(input[3])==output[3]){
							
				//  All Correct! となる最少の k を手に入れる。
				k = i; 
				System.out.println("All Correct! when k = "+k);
							
				// for文を強制的に脱出。
				break;
			
			}
		}
		
		for(int i=0 ; i<output.length;i++){
			if(plib.getOutput(input[i]) == output[i])
				System.out.println("Correct! : input("+input[i][0]+","+input[i][1]+") to output("+output[i]+")");
			else System.out.println("Miss! : input("+input[i][0]+","+input[i][1]+") to output("+output[i]+")");
		}
		
		System.out.println("Check : nu = "+nu[0]+", "+nu[1]);
	
	}

}
//  このプログラムによると　k=0 （ほど）でAND演算は出来上がる模様。　それじゃあ少しつまらない。
//　なので、　P⇒Q　とか　P XOR Q　とか　P NOR Q　とか　P NAND Q　とか　P ≡ Q　とか入れてみた。
//   しかしながら、　P⇒Q　も　P XOR Q も他のやつも for(int i=0;i <10000;i++){ ... } の試行では　ALL Correct! にすることはできなかった。
//　 すなわち、正しい結果を得ることが出来ない論理演算があると考えられる。
//   各種の論理演算の結果から、根本的に、{0,0} → {1}　と　{1,1} → {0} 　が出来ないのではないかという考えに至った。