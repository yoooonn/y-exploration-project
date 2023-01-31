// /*
//  * Decompiled with CFR.
//  *
//  * Could not load the following classes:
//  *  com.ycourlee.explore.javalib.cglib.Foo
//  */
// package com.ycourlee.explore.javalib.cglib;
//
// import net.sf.cglib.core.Signature;
// import net.sf.cglib.reflect.FastClass;
//
// import java.lang.reflect.InvocationTargetException;
//
// public class Foo$$FastClassByCGLIB$$42ab609c
//         extends FastClass {
//
//     @Override
//     public int getMaxIndex() {
//         return 5;
//     }
//
//     @Override
//     public Object invoke(int n, Object object, Object[] objectArray) throws InvocationTargetException {
//         Foo foo = (Foo) object;
//         try {
//             switch (n) {
//                 case 0: {
//                     return foo.getA();
//                 }
//                 case 1: {
//                     foo.setA((Integer) objectArray[0]);
//                     return null;
//                 }
//                 case 2: {
//                     return foo.toString();
//                 }
//                 case 3: {
//                     foo.b();
//                     return null;
//                 }
//                 case 4: {
//                     return new Boolean(foo.equals(objectArray[0]));
//                 }
//                 case 5: {
//                     return new Integer(foo.hashCode());
//                 }
//             }
//         } catch (Throwable throwable) {
//             throw new InvocationTargetException(throwable);
//         }
//         throw new IllegalArgumentException("Cannot find matching method/constructor");
//     }
//
//     public Foo$$FastClassByCGLIB$$42ab609c(Class clazz) {
//         super(clazz);
//     }
//
//     @Override
//     public Object newInstance(int n, Object[] objectArray) throws InvocationTargetException {
//         try {
//             switch (n) {
//                 case 0: {
//                     return new Foo();
//                 }
//             }
//         } catch (Throwable throwable) {
//             throw new InvocationTargetException(throwable);
//         }
//         throw new IllegalArgumentException("Cannot find matching method/constructor");
//     }
//
//     @Override
//     public int getIndex(Class[] classArray) {
//         Class[] classArray2 = classArray;
//         switch (classArray.length) {
//             case 0: {
//                 return 0;
//             }
//         }
//         return -1;
//     }
//
//     @Override
//     public int getIndex(String string, Class[] classArray) {
//         String string2 = string;
//         Class[] classArray2 = classArray;
//         block0:
//         switch (string2.hashCode()) {
//             case -1776922004: {
//                 if (!string2.equals("toString"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 0: {
//                         return 2;
//                     }
//                 }
//                 break;
//             }
//             case -1295482945: {
//                 if (!string2.equals("equals"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 1: {
//                         classArray2 = classArray2;
//                         if (!classArray2[0].getName().equals("java.lang.Object"))
//                             break block0;
//                         return 4;
//                     }
//                 }
//                 break;
//             }
//             case 98: {
//                 if (!string2.equals("b"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 0: {
//                         return 3;
//                     }
//                 }
//                 break;
//             }
//             case 3169195: {
//                 if (!string2.equals("getA"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 0: {
//                         return 0;
//                     }
//                 }
//                 break;
//             }
//             case 3526687: {
//                 if (!string2.equals("setA"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 1: {
//                         classArray2 = classArray2;
//                         if (!classArray2[0].getName().equals("java.lang.Integer"))
//                             break block0;
//                         return 1;
//                     }
//                 }
//                 break;
//             }
//             case 147696667: {
//                 if (!string2.equals("hashCode"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 0: {
//                         return 5;
//                     }
//                 }
//                 break;
//             }
//         }
//         return -1;
//     }
//
//     @Override
//     public int getIndex(Signature signature) {
//         String string = ((Object) signature).toString();
//         switch (string.hashCode()) {
//             case -1638303807: {
//                 if (!string.equals("setA(Ljava/lang/Integer;)V"))
//                     break;
//                 return 1;
//             }
//             case 2959315: {
//                 if (!string.equals("b()V"))
//                     break;
//                 return 3;
//             }
//             case 529159313: {
//                 if (!string.equals("getA()Ljava/lang/Integer;"))
//                     break;
//                 return 0;
//             }
//             case 1826985398: {
//                 if (!string.equals("equals(Ljava/lang/Object;)Z"))
//                     break;
//                 return 4;
//             }
//             case 1913648695: {
//                 if (!string.equals("toString()Ljava/lang/String;"))
//                     break;
//                 return 2;
//             }
//             case 1984935277: {
//                 if (!string.equals("hashCode()I"))
//                     break;
//                 return 5;
//             }
//         }
//         return -1;
//     }
// }
