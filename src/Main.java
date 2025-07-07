public class Main {
    public static void main(String[] args) {
        Student st = new Student();
        st.createTable();
        st.createData();
        st.readData();
        st.updateData(13, "Ajit");
        st.readData();
        st.deleteData(13);
        st.readData();
    }
}
