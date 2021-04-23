package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: 柴俊杰
 * @Description:
 * @Date: 2021/4/15 18:39
 */
public class StringBuilderTest {
	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder();
		Set<String> stringSet = new HashSet<>();
		stringSet.add("ProjpInvoiceReq");
		stringSet.add("ProjpInvoiceReqVO");
		stringSet.add("ProjpPayReq");
		stringSet.add("ProjpPayReq");
		stringSet.add("ProjpPayReq");
		stringSet.add("ProjpPayReqVO");
		stringSet.add("ProjpPayReqVO");
		stringSet.add("ProjpPayReqVO");
		stringSet.stream().forEach(obj->{
			stringBuilder.append(obj+",");
		});
		System.out.println(stringBuilder.toString().substring(0,stringBuilder.length()-1));
	}
}
