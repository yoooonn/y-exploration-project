// /*
//  * Decompiled with CFR.
//  */
// package top.yooonn.explore.notes.cloud.aio.other;
//
// import org.springframework.beans.factory.BeanFactory;
// import org.springframework.cglib.core.Signature;
// import org.springframework.cglib.proxy.Callback;
// import org.springframework.cglib.reflect.FastClass;
//
// import java.lang.reflect.InvocationTargetException;
//
// public class DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0$$FastClassBySpringCGLIB$$c9ef52c8
//         extends FastClass {
//
//     public BeanFactory $$beanFactory;
//
//     public DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0$$FastClassBySpringCGLIB$$c9ef52c8(Class clazz) {
//         super(clazz);
//     }
//
//     @Override
//     public int getIndex(Signature signature) {
//         String string = ((Object) signature).toString();
//         switch (string.hashCode()) {
//             case -1870561232: {
//                 if (!string.equals("CGLIB$findMethodProxy(Lorg/springframework/cglib/core/Signature;)Lorg/springframework/cglib/proxy/MethodProxy;"))
//                     break;
//                 return 8;
//             }
//             case -1830747790: {
//                 if (!string.equals("b()Lcom/ycourlee/explore/notes/cloud/aio/other/B;"))
//                     break;
//                 return 9;
//             }
//             case -1822988462: {
//                 if (!string.equals("a()Lcom/ycourlee/explore/notes/cloud/aio/other/A;"))
//                     break;
//                 return 10;
//             }
//             case -1457476106: {
//                 if (!string.equals("CGLIB$STATICHOOK3()V"))
//                     break;
//                 return 3;
//             }
//             case -1457446315: {
//                 if (!string.equals("CGLIB$STATICHOOK4()V"))
//                     break;
//                 return 7;
//             }
//             case -1034266769: {
//                 if (!string.equals("CGLIB$SET_STATIC_CALLBACKS([Lorg/springframework/cglib/proxy/Callback;)V"))
//                     break;
//                 return 0;
//             }
//             case -1025895669: {
//                 if (!string.equals("CGLIB$SET_THREAD_CALLBACKS([Lorg/springframework/cglib/proxy/Callback;)V"))
//                     break;
//                 return 1;
//             }
//             case -298197737: {
//                 if (!string.equals("afterSingletonsInstantiated()V"))
//                     break;
//                 return 11;
//             }
//             case -85131779: {
//                 if (!string.equals("CGLIB$a$2()Lcom/ycourlee/explore/notes/cloud/aio/other/A;"))
//                     break;
//                 return 5;
//             }
//             case 1055818204: {
//                 if (!string.equals("CGLIB$b$1()Lcom/ycourlee/explore/notes/cloud/aio/other/B;"))
//                     break;
//                 return 4;
//             }
//             case 1826985398: {
//                 if (!string.equals("equals(Ljava/lang/Object;)Z"))
//                     break;
//                 return 12;
//             }
//             case 1913648695: {
//                 if (!string.equals("toString()Ljava/lang/String;"))
//                     break;
//                 return 13;
//             }
//             case 1984935277: {
//                 if (!string.equals("hashCode()I"))
//                     break;
//                 return 14;
//             }
//             case 2095635076: {
//                 if (!string.equals("setBeanFactory(Lorg/springframework/beans/factory/BeanFactory;)V"))
//                     break;
//                 return 2;
//             }
//             case 2116294234: {
//                 if (!string.equals("CGLIB$setBeanFactory$7(Lorg/springframework/beans/factory/BeanFactory;)V"))
//                     break;
//                 return 6;
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
//                         return 13;
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
//                         return 12;
//                     }
//                 }
//                 break;
//             }
//             case -1013651080: {
//                 if (!string2.equals("setBeanFactory"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 1: {
//                         classArray2 = classArray2;
//                         if (!classArray2[0].getName().equals("org.springframework.beans.factory.BeanFactory"))
//                             break block0;
//                         return 2;
//                     }
//                 }
//                 break;
//             }
//             case -772032244: {
//                 if (!string2.equals("CGLIB$a$2"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 0: {
//                         return 5;
//                     }
//                 }
//                 break;
//             }
//             case -772031284: {
//                 if (!string2.equals("CGLIB$b$1"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 0: {
//                         return 4;
//                     }
//                 }
//                 break;
//             }
//             case -98766434: {
//                 if (!string2.equals("afterSingletonsInstantiated"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 0: {
//                         return 11;
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
//                         if (!classArray2[0].getName().equals("[Lorg.springframework.cglib.proxy.Callback;"))
//                             break block0;
//                         return 0;
//                     }
//                 }
//                 break;
//             }
//             case 97: {
//                 if (!string2.equals("a"))
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
//                         return 9;
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
//                         if (!classArray2[0].getName().equals("[Lorg.springframework.cglib.proxy.Callback;"))
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
//                         return 14;
//                     }
//                 }
//                 break;
//             }
//             case 161998111: {
//                 if (!string2.equals("CGLIB$STATICHOOK3"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 0: {
//                         return 3;
//                     }
//                 }
//                 break;
//             }
//             case 161998112: {
//                 if (!string2.equals("CGLIB$STATICHOOK4"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 0: {
//                         return 7;
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
//                         if (!classArray2[0].getName().equals("org.springframework.cglib.core.Signature"))
//                             break block0;
//                         return 8;
//                     }
//                 }
//                 break;
//             }
//             case 1418553038: {
//                 if (!string2.equals("CGLIB$setBeanFactory$7"))
//                     break;
//                 classArray2 = classArray2;
//                 switch (classArray2.length) {
//                     case 1: {
//                         classArray2 = classArray2;
//                         if (!classArray2[0].getName().equals("org.springframework.beans.factory.BeanFactory"))
//                             break block0;
//                         return 6;
//                     }
//                 }
//                 break;
//             }
//         }
//         return -1;
//     }
//
//     @Override
//     public int getIndex(Class[] classArray) {
//         Class[] classArray2 = classArray;
//         switch (classArray.length) {
//             case 1: {
//                 classArray2 = classArray2;
//                 if (!classArray2[0].getName().equals("org.springframework.beans.factory.BeanFactory"))
//                     break;
//                 return 0;
//             }
//         }
//         return -1;
//     }
//
//     @Override
//     public Object invoke(int n, Object object, Object[] objectArray) throws InvocationTargetException {
//         DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0 declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0 = (DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0) object;
//         try {
//             switch (n) {
//                 case 0: {
//                     DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.CGLIB$SET_STATIC_CALLBACKS((Callback[]) objectArray[0]);
//                     return null;
//                 }
//                 case 1: {
//                     DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.CGLIB$SET_THREAD_CALLBACKS((Callback[]) objectArray[0]);
//                     return null;
//                 }
//                 case 2: {
//                     declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.setBeanFactory((BeanFactory) objectArray[0]);
//                     return null;
//                 }
//                 case 3: {
//                     DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.CGLIB$STATICHOOK3();
//                     return null;
//                 }
//                 case 4: {
//                     return declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.CGLIB$b$1();
//                 }
//                 case 5: {
//                     return declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.CGLIB$a$2();
//                 }
//                 case 6: {
//                     declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.CGLIB$setBeanFactory$7((BeanFactory) objectArray[0]);
//                     return null;
//                 }
//                 case 7: {
//                     DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.CGLIB$STATICHOOK4();
//                     return null;
//                 }
//                 case 8: {
//                     return DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.CGLIB$findMethodProxy((Signature) objectArray[0]);
//                 }
//                 case 9: {
//                     return declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.b();
//                 }
//                 case 10: {
//                     return declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.a();
//                 }
//                 case 11: {
//                     declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.afterSingletonsInstantiated();
//                     return null;
//                 }
//                 case 12: {
//                     return new Boolean(declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.equals(objectArray[0]));
//                 }
//                 case 13: {
//                     return declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.toString();
//                 }
//                 case 14: {
//                     return new Integer(declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.hashCode());
//                 }
//             }
//         } catch (Throwable throwable) {
//             throw new InvocationTargetException(throwable);
//         }
//         throw new IllegalArgumentException("Cannot find matching method/constructor");
//     }
//
//     @Override
//     public Object newInstance(int n, Object[] objectArray) throws InvocationTargetException {
//         try {
//             switch (n) {
//                 case 0: {
//                     return new DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0((BeanFactory) objectArray[0]);
//                 }
//             }
//         } catch (Throwable throwable) {
//             throw new InvocationTargetException(throwable);
//         }
//         throw new IllegalArgumentException("Cannot find matching method/constructor");
//     }
//
//     @Override
//     public int getMaxIndex() {
//         return 14;
//     }
// }
