package aroundMethodPattern;

import java.util.function.Consumer;

/**
 * Created by tomek on 16.07.16.
 */
class Resource{

        private Resource(){
            System.out.println("created...");
        }
        public Resource op1(){
            System.out.println("op1");
            return this;
        }

        public Resource op2(){
            System.out.println("op2");
            return this;
        }


        private void close(){
            System.out.println("close ...");
        }

        public static void use(Consumer<Resource> block){
            Resource resource = new Resource();
            try{
                block.accept(resource);
            }finally {
                resource.close();
            }
        }

 }
public class Around {


    public static void main(String[] args){

        Resource.use(resource ->
            resource.op1()
                     .op2());
    }

}


