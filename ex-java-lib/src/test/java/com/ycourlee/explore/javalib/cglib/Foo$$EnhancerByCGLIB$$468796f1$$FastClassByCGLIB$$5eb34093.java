// /*
//  * Decompiled with CFR.
//  */
// package com.ycourlee.explore.javalib.cglib;
//
// import net.sf.cglib.core.Signature;
// import net.sf.cglib.proxy.Callback;
// import net.sf.cglib.reflect.FastClass;
//
// import java.lang.reflect.InvocationTargetException;
//
// public class Foo$$EnhancerByCGLIB$$468796f1$$FastClassByCGLIB$$5eb34093
//         extends FastClass {
//
//     @Override
//     public int getMaxIndex() {
//         return 17;
//     }
//
//     @Override
//     public Object invoke(int n, Object object, Object[] objectArray) throws InvocationTargetException {
//         Foo$$EnhancerByCGLIB$$468796f1 foo$$EnhancerByCGLIB$$468796f1 = (Foo$$EnhancerByCGLIB$$468796f1) ((Object) object);
//         try {
//             switch (n) {
//                 case 0: {
//                     Foo$$EnhancerByCGLIB$$468796f1.CGLIB$SET_STATIC_CALLBACKS((Callback[]) objectArray[0]);
//                     return null;
//                 }
//                 case 1: {
//                     Foo$$EnhancerByCGLIB$$468796f1.CGLIB$SET_THREAD_CALLBACKS((Callback[]) objectArray[0]);
//                     return null;
//                 }
//                 case 2: {
//                     return foo$$EnhancerByCGLIB$$468796f1.getA();
//                 }
//                 case 3: {
//                     foo$$EnhancerByCGLIB$$468796f1.setA((Integer) objectArray[0]);
//                     return null;
//                 }
//                 case 4: {
//                     return foo$$EnhancerByCGLIB$$468796f1.CGLIB$getA$0();
//                 }
//                 case 5: {
//                     foo$$EnhancerByCGLIB$$468796f1.CGLIB$setA$1((Integer) objectArray[0]);
//                     return null;
//                 }
//                 case 6: {
//                     Foo$$EnhancerByCGLIB$$468796f1.CGLIB$STATICHOOK1();
//                     return null;
//                 }
//                 case 7: {
//                     return foo$$EnhancerByCGLIB$$468796f1.CGLIB$toString$2();
//                 }
//                 case 8: {
//                     foo$$EnhancerByCGLIB$$468796f1.CGLIB$b$3();
//                     return null;
//                 }
//                 case 9: {
//                     return new Boolean(foo$$EnhancerByCGLIB$$468796f1.CGLIB$equals$4(objectArray[0]));
//                 }
//                 case 10: {
//                     return new Integer(foo$$EnhancerByCGLIB$$468796f1.CGLIB$hashCode$5());
//                 }
//                 case 11: {
//                     return foo$$EnhancerByCGLIB$$468796f1.CGLIB$clone$6();
//                 }
//                 case 12: {
//                     return Foo$$EnhancerByCGLIB$$468796f1.CGLIB$findMethodProxy((Signature) objectArray[0]);
//                 }
//                 case 13: {
//                     return new Boolean(foo$$EnhancerByCGLIB$$468796f1.equals(objectArray[0]));
//                 }
//                 case 14: {
//                     return foo$$EnhancerByCGLIB$$468796f1.toString();
//                 }
//                 case 15: {
//                     return new Integer(foo$$EnhancerByCGLIB$$468796f1.hashCode());
//                 }
//                 case 16: {
//                     return foo$$EnhancerByCGLIB$$468796f1.clone();
//                 }
//                 case 17: {
//                     foo$$EnhancerByCGLIB$$468796f1.b();
//                     return null;
//                 }
//             }
//         } catch (Throwable throwable) {
//             throw new InvocationTargetException(throwable);
//         }
//         throw new IllegalArgumentException("Cannot find matching method/constructor");
//     }
//
//     public Foo$$EnhancerByCGLIB$$468796f1$$FastClassByCGLIB$$5eb34093(Class clazz) {
//         super(clazz);
//     }
//
//     @Override
//     public Object newInstance(int n, Object[] objectArray) throws InvocationTargetException {
//         try {
//             switch (n) {
//                 case 0: {
//                     return new Foo$$EnhancerByCGLIB$$468796f1();
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
//                         return 14;
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
//                         return 13;
//                     }
//                 }
//                 break;
//             }
//             case -772031282: {
//                 if (!string2.equals("CGLIB$b$3"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 0: {
//                         return 8;
//                     }
//                 }
//                 break;
//             }
//             case -124978606: {
//                 if (!string2.equals("CGLIB$equals$4"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 1: {
//                         classArray2 = classArray2;
//                         if (!classArray2[0].getName().equals("java.lang.Object"))
//                             break block0;
//                         return 9;
//                     }
//                 }
//                 break;
//             }
//             case -60403779: {
//                 if (!string2.equals("CGLIB$SET_STATIC_CALLBACKS"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 1: {
//                         classArray2 = classArray2;
//                         if (!classArray2[0].getName().equals("[Lnet.sf.cglib.proxy.Callback;"))
//                             break block0;
//                         return 0;
//                     }
//                 }
//                 break;
//             }
//             case -29025553: {
//                 if (!string2.equals("CGLIB$hashCode$5"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 0: {
//                         return 10;
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
//                         return 17;
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
//                         return 2;
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
//                         return 3;
//                     }
//                 }
//                 break;
//             }
//             case 85179481: {
//                 if (!string2.equals("CGLIB$SET_THREAD_CALLBACKS"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 1: {
//                         classArray2 = classArray2;
//                         if (!classArray2[0].getName().equals("[Lnet.sf.cglib.proxy.Callback;"))
//                             break block0;
//                         return 1;
//                     }
//                 }
//                 break;
//             }
//             case 0x5A5DD5D: {
//                 if (!string2.equals("clone"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 0: {
//                         return 16;
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
//                         return 15;
//                     }
//                 }
//                 break;
//             }
//             case 161998109: {
//                 if (!string2.equals("CGLIB$STATICHOOK1"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 0: {
//                         return 6;
//                     }
//                 }
//                 break;
//             }
//             case 171122682: {
//                 if (!string2.equals("CGLIB$getA$0"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 0: {
//                         return 4;
//                     }
//                 }
//                 break;
//             }
//             case 514672495: {
//                 if (!string2.equals("CGLIB$setA$1"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 1: {
//                         classArray2 = classArray2;
//                         if (!classArray2[0].getName().equals("java.lang.Integer"))
//                             break block0;
//                         return 5;
//                     }
//                 }
//                 break;
//             }
//             case 1154623345: {
//                 if (!string2.equals("CGLIB$findMethodProxy"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 1: {
//                         classArray2 = classArray2;
//                         if (!classArray2[0].getName().equals("net.sf.cglib.core.Signature"))
//                             break block0;
//                         return 12;
//                     }
//                 }
//                 break;
//             }
//             case 1543336189: {
//                 if (!string2.equals("CGLIB$toString$2"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 0: {
//                         return 7;
//                     }
//                 }
//                 break;
//             }
//             case 1951977612: {
//                 if (!string2.equals("CGLIB$clone$6"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 0: {
//                         return 11;
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
//             case -2071771415: {
//                 if (!string.equals("CGLIB$clone$6()Ljava/lang/Object;"))
//                     break;
//                 return 11;
//             }
//             case -2055565910: {
//                 if (!string.equals("CGLIB$SET_THREAD_CALLBACKS([Lnet/sf/cglib/proxy/Callback;)V"))
//                     break;
//                 return 1;
//             }
//             case -1638303807: {
//                 if (!string.equals("setA(Ljava/lang/Integer;)V"))
//                     break;
//                 return 3;
//             }
//             case -1457535688: {
//                 if (!string.equals("CGLIB$STATICHOOK1()V"))
//                     break;
//                 return 6;
//             }
//             case -1411783143: {
//                 if (!string.equals("CGLIB$hashCode$5()I"))
//                     break;
//                 return 10;
//             }
//             case -1326536798: {
//                 if (!string.equals("CGLIB$getA$0()Ljava/lang/Integer;"))
//                     break;
//                 return 4;
//             }
//             case -1219652847: {
//                 if (!string.equals("CGLIB$setA$1(Ljava/lang/Integer;)V"))
//                     break;
//                 return 5;
//             }
//             case -623122092: {
//                 if (!string.equals("CGLIB$findMethodProxy(Lnet/sf/cglib/core/Signature;)Lnet/sf/cglib/proxy/MethodProxy;"))
//                     break;
//                 return 12;
//             }
//             case -508378822: {
//                 if (!string.equals("clone()Ljava/lang/Object;"))
//                     break;
//                 return 16;
//             }
//             case -34012185: {
//                 if (!string.equals("CGLIB$b$3()V"))
//                     break;
//                 return 8;
//             }
//             case 2959315: {
//                 if (!string.equals("b()V"))
//                     break;
//                 return 17;
//             }
//             case 529159313: {
//                 if (!string.equals("getA()Ljava/lang/Integer;"))
//                     break;
//                 return 2;
//             }
//             case 593200387: {
//                 if (!string.equals("CGLIB$equals$4(Ljava/lang/Object;)Z"))
//                     break;
//                 return 9;
//             }
//             case 1306468936: {
//                 if (!string.equals("CGLIB$toString$2()Ljava/lang/String;"))
//                     break;
//                 return 7;
//             }
//             case 1584330438: {
//                 if (!string.equals("CGLIB$SET_STATIC_CALLBACKS([Lnet/sf/cglib/proxy/Callback;)V"))
//                     break;
//                 return 0;
//             }
//             case 1826985398: {
//                 if (!string.equals("equals(Ljava/lang/Object;)Z"))
//                     break;
//                 return 13;
//             }
//             case 1913648695: {
//                 if (!string.equals("toString()Ljava/lang/String;"))
//                     break;
//                 return 14;
//             }
//             case 1984935277: {
//                 if (!string.equals("hashCode()I"))
//                     break;
//                 return 15;
//             }
//         }
//         return -1;
//     }
// }
