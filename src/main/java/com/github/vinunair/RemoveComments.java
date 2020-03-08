package com.github.vinunair;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> filteredSource = new ArrayList<>();
        boolean foundBlockComment = false;
        int position = 0;
        for(String line : source) {
            String parsedLine = line;
            StringBuilder sourceBuilder = new StringBuilder();
            while(parsedLine.length()!=0) {
                if(!foundBlockComment) {
                    int lineCommentPosition = parsedLine.indexOf("//") ;
                    int blockCommentPosition = parsedLine.indexOf("/*");
                    
                    if(lineCommentPosition==-1 && blockCommentPosition==-1)
                        position = parsedLine.length();
                    else if(blockCommentPosition ==-1 || (lineCommentPosition!=-1 && lineCommentPosition < blockCommentPosition ))
                        position = lineCommentPosition;
                    else {
                        position = blockCommentPosition;    
                        foundBlockComment=true;    
                    }

                    if(position > 0) {  
                        sourceBuilder = sourceBuilder.append(line.substring(0,position)); 
                        position+=2;
                    }
                }
                if(foundBlockComment) {
                    int closeCommentPosition = parsedLine.indexOf("*/",position);
                    if(closeCommentPosition > -1){ 
                        foundBlockComment = false;
                    parsedLine = parsedLine.substring(closeCommentPosition+2);
                    }
                    else {
                        parsedLine="";
                    }                    
                }
            }
            filteredSource.add(sourceBuilder.toString()); 
            }
            return filteredSource;    
        }


    public static void main(String args[]) {
      //  String[] source =  {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
       // String[] source = {"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"};
      //  String [] source ={"a/*comment", "line", "more_comment*/b"};
     //  String []source = {"d/*/e*//f"};
     String [] source = {"a/*/b//*c","blank","d/*/e*//f"};
        RemoveComments removeComments = new RemoveComments();
        System.out.println(removeComments.removeComments(source));
    //     String line = "/*/ declare members;/**/";
    //     System.out.println(line.indexOf("*/",2));
    }
}