package pojo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PlainOldJavaObject {
	private String name;
	private int age;

	public PlainOldJavaObject() {
	}

	public PlainOldJavaObject(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) {

	    try {
	        ObjectMapper mapper = new ObjectMapper();

	        PlainOldJavaObject obj = new PlainOldJavaObject("Dharma", 10);

	        // Serialize (convert object to JSON string)
	        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
	        System.out.println("Serialized JSON:");
	        System.out.println(jsonString);

	        // Write to file (optional)
	        //mapper.writeValue(new File("object.json"), obj);

	        // Deserialize (read JSON back to object)
	        PlainOldJavaObject readObj = mapper.readValue(jsonString, PlainOldJavaObject.class);

	        System.out.println("\nDeserialized Object:");
	        System.out.println("Name: " + readObj.getName());
	        System.out.println("Age: " + readObj.getAge());

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
