.class public frame_1 
.super java/lang/Object 
.field public sl Lframe_0; 
.field public v0 I 

.end method 

;
; standard initializer
.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V
       ; set limits used by this method
       .limit locals  4
       .limit stack 256

       ; setup local variables:

       ;    1 - the PrintStream object held in java.lang.System.out
       getstatic java/lang/System/out Ljava/io/PrintStream;

       ; place your bytecodes here
       ; START

     aconst_null
     astore_3
     new frame_0
     dup
     invokespecial frame_0/<init>()V
     dup
     aload_3
     outfield frame_0/sl Ljava/lang/Object;
     dup
     astore_3
     dup
     sipush3
     outfield frame_0/v0 I
     pop
     sipush 3
     sipush 3
     iadd
     aload_3
     getfield frame_0/sl Ljava/lang/Object;
     astore_3

       ; END


       ; convert to String;
       invokestatic java/lang/String/valueOf(I)Ljava/lang/String;
       
       ; call println 
       invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

       return

.end method