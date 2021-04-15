package sort;

/**
 * @Author: 柴俊杰
 * @Description:
 * @Date: 2021/3/23 19:59
 */
public class StringTest {
	public static void main(String[] args) {
		String str = "ABCDEFGH";
		String tr = "EFG";
		String[] split = str.split("");
		String[] split1 = tr.split("");
		for (int i=0;i<split.length;i++) {
			for (int j=0;j<split1.length;j++) {
				if(!split[i].equals(split1[j])){
					while (j<split1.length){
						if(!split[i++].equals(split1[j++])){
							return;
						}
					}
					System.out.println(i);
				}
			}
		}
	}
}
