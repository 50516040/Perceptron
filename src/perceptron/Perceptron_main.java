package perceptron;

public class Perceptron_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double nu[] = {0.35, 0.2};
		Perceptron_lib plib = new Perceptron_lib(2, nu, 0.01, 0.5);
	
//AND���Z�������Ƃ܂�Ȃ��̂ŁA�F�X�ȉ��Z������Ă݂��B
		
//OR���Z
//		double input[][] = { {0,0},{0,1},{1,0},{1,1}};
//		double output[] = { 0, 1, 1, 1};
		
//AND���Z
		double input[][] = { {0,0}, {0,1}, {1,0}, {1,1}};
		double output[] = { 0, 0, 0, 1};

//P��Q 
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

//P��Q
//		double input[][] = { {0,0}, {0,1}, {1,0}, {1,1}};
//		double output[] = { 1, 0, 0, 1};
		
		
		int index,k=0;
		for(int i = 0; i < 10000; i++){
			index = (int)(Math.random()*4);
			plib.getParameter(input[index], output[index]);
			System.out.println("index : "+i+"nu = "+nu[0]+", "+nu[1]);
			
			if(plib.getOutput(input[0])==output[0] && plib.getOutput(input[1])==output[1] &&
					plib.getOutput(input[2])==output[2] && plib.getOutput(input[3])==output[3]){
							
				//  All Correct! �ƂȂ�ŏ��� k ����ɓ����B
				k = i; 
				System.out.println("All Correct! when k = "+k);
							
				// for���������I�ɒE�o�B
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
//  ���̃v���O�����ɂ��Ɓ@k=0 �i�قǁj��AND���Z�͏o���オ��͗l�B�@���ꂶ�Ⴀ�����܂�Ȃ��B
//�@�Ȃ̂ŁA�@P��Q�@�Ƃ��@P XOR Q�@�Ƃ��@P NOR Q�@�Ƃ��@P NAND Q�@�Ƃ��@P �� Q�@�Ƃ�����Ă݂��B
//   �������Ȃ���A�@P��Q�@���@P XOR Q �����̂�� for(int i=0;i <10000;i++){ ... } �̎��s�ł́@ALL Correct! �ɂ��邱�Ƃ͂ł��Ȃ������B
//�@ ���Ȃ킿�A���������ʂ𓾂邱�Ƃ��o���Ȃ��_�����Z������ƍl������B
//   �e��̘_�����Z�̌��ʂ���A���{�I�ɁA{0,0} �� {1}�@�Ɓ@{1,1} �� {0} �@���o���Ȃ��̂ł͂Ȃ����Ƃ����l���Ɏ������B