package exception;

/**
 * @Author: 柴俊杰
 * @Description: 自定义异常类
 * @Date: 2021/4/22 11:14
 */
public class SelfException extends RuntimeException {
	public SelfException(){
		super();
	}
	public SelfException(String message){
		super("自定义异常");
	}
}
