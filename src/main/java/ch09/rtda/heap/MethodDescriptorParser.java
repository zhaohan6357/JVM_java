package ch09.rtda.heap;

import ch09.rtda.heap.MethodDescriptor;
import org.joou.UInteger;

import javax.swing.plaf.basic.BasicTreeUI;

public class MethodDescriptorParser {
    String raw;
    int offset;
    MethodDescriptor parsed;
    public static MethodDescriptor parseMethodDescriptor(String descriptor){
        MethodDescriptorParser parser=new MethodDescriptorParser();
        return parser.parse(descriptor);
    }
    public MethodDescriptor parse(String descriptor){
        this.raw=descriptor;
        this.parsed=new MethodDescriptor();
        this.startParams();
        this.parseParamTypes();
        this.endParams();
        this.parseReturnType();
        this.finish();
        return this.parsed;
    }
    private void startParams() {
        if (this.readUint8() != '(') {
            this.causePanic();
        }
    }

    private char readUint8(){
        char b=this.raw.charAt(this.offset);
        this.offset++;
        return b;
    }
    private void unreadUint8(){
        this.offset--;
    }
    private void causePanic(){
        System.out.println("BAD descrioptor:"+this.raw);
        System.exit(1);
    }


    private String parseFieldType(){
        switch (this.readUint8()){
            case 'B':
                return "B";
            case 'C':
                return "C";
            case 'D':
                return "D";
            case 'F':
                return "F";
            case 'I':
                return "I";
            case 'J':
                return "J";
            case 'S':
                return "S";
            case 'Z':
                return "Z";
            case 'L':
                return this.parseObjectType();
            case '[':
                return this.parseArrayType();
             default:
                 this.unreadUint8();
                 return "";

        }
    }
    private String parseObjectType(){
        String unread=this.raw.substring(offset);
        int semicolonIndex=unread.indexOf(';');
        if(semicolonIndex==-1){
            this.causePanic();
            return "";
        }
        int objStart=this.offset-1;
        int objEnd=this.offset+semicolonIndex+1;
        this.offset=objEnd;//todo noticed 描述符包含分号  终结符
        String descriptor=raw.substring(objStart,objEnd);
        return descriptor;
    }

    private String parseArrayType(){
        int arrStart=this.offset-1;
        this.parseFieldType();
        int arrEnd=this.offset;
        String descriptor=raw.substring(arrStart,arrEnd);
        return descriptor;
    }

    private void parseParamTypes() {
        while(true){
            String t=this.parseFieldType();
            if(!t.equals("")){
                this.parsed.addParameterType(t);
            }else{
                break;
            }
        }
    }

    private void endParams() {
        if(this.readUint8()!=')'){
            this.causePanic();
        }
    }
    private void parseReturnType() {
        if(this.readUint8()=='V'){
            this.parsed.returnType="V";
            return;
        }
        this.unreadUint8();
        String t=this.parseFieldType();
        if(!t.equals("")){
            this.parsed.returnType=t;
            return;
        }
        this.causePanic();
    }
    private void finish() {
        if(this.offset!=raw.length()){
            this.causePanic();
        }
    }

    public static void main(String[] args) {
        MethodDescriptorParser.parseMethodDescriptor("([Ljava/lang/String;ZILjava/lang/String;II)Z");
    }

}
