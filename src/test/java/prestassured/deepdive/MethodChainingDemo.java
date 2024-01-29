package prestassured.deepdive;

public class MethodChainingDemo {
    public static void main(String[] args){
        /**var p = new Person();
        p.setName("Nilesh");
        p.setId(10);*/

        //Invoke method chaining
        var p = new Person()
                .setName("Nilesh")
                .setId(10);

    }

    static class Person {
        String name;
        int id;

        /**public void setName(String name){
            this.name = name;
        }

        public void setId(int id){
            this.id = id;
        }*/

        //Method chaining
        public Person setName(String name){
            this.name = name;
            return this;
        }

        public Person setId(int id){
            this.id = id;
            return this;
        }
    }
}
