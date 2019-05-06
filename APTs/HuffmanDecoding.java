public class HuffmanDecoding {
    public String decode(String archive, String[] dictionary) {
        String output = "";
        while(archive.length() > 0){
            for (int v = 0; v < dictionary.length; v++){
                if (archive.startsWith(dictionary[v])){
                    output = output + (char)('A' + v);
                    archive = archive.substring(dictionary[v].length(), archive.length());
                }
            }
        }
        return output;
    }
}