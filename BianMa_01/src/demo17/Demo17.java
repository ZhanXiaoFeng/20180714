
/**  
* @Title: Demo17.java
* @Package demo17
* @Description: ���ö�̬����
* @author ZRF
* @date 2018��6��21��
* @version V1.0  
*/

package demo17;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * @ClassName: Demo17
 * @Description: ���ö�̬����
 * @author ZRF
 * @date 2018��6��21��
 */

public class Demo17 {
	public static void main(String[] args) throws Exception {
		// Java Դ����
		String sourceStr = "public class Hello{public String sayHello (String name){return \"Hello,\" + name + \"!\";}}";
		// �������ļ���
		String clsName = "Hello";
		// ������
		String methodName = "sayHello";
		// ��ǰ������
		JavaCompiler cmp = ToolProvider.getSystemJavaCompiler();
		// Java ��׼�ļ�������
		StandardJavaFileManager fm = cmp.getStandardFileManager(null, null, null);
		// Java �ļ�����
		JavaFileObject jfo = new StringJavaObject(clsName, sourceStr);
		// ��������� ������ javac <options> �е� options
		List<String> optionsList = new ArrayList<String>();
		// �����ļ��Ĵ�ŵط��� ע�⣺ �˴���Ϊ Eclipse ���������
		optionsList.addAll(Arrays.asList("-d", "./bin"));
		// Ҫ����ĵ�Ԫ
		List<JavaFileObject> jfos = Arrays.asList(jfo);
		// ���ñ��뻷��
		JavaCompiler.CompilationTask task = cmp.getTask(null, fm, null, optionsList, null, jfos);
		// ����ɹ�
		if (task.call()) {
			// ���ɶ���
			Object obj = Class.forName(clsName).newInstance();
			Class<? extends Object> cls = obj.getClass();
			// ���� sayHello ����
			Method m = cls.getMethod(methodName, String.class);
			String str = (String) m.invoke(obj, "Dynamic Compilation");
			System.out.println(str);
		}
	}
}

// �ı��е� Java ����
class StringJavaObject extends SimpleJavaFileObject {
	// Դ����
	private String content = "";

	// ��ѭ Java �淶���������ļ�
	public StringJavaObject(String _javaFileName, String _content) {
		super(_createStringJavaObjectUri(_javaFileName), Kind.SOURCE);
		content = _content;
	}

	// ����һ�� URL ��Դ·��
	private static URI _createStringJavaObjectUri(String name) {
		// ע��˴�û�����ð���
		return URI.create("String:///" + name + Kind.SOURCE.extension);
	}

	// �ı��ļ�����
	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
		return content;
	}

}
