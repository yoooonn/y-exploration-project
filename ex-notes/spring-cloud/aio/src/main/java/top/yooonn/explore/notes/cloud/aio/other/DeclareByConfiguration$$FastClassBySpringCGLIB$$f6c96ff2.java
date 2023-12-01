// /*
//  * Decompiled with CFR.
//  *
//  * Could not load the following classes:
//  *  com.ycourlee.explore.notes.cloud.aio.other.DeclareByConfiguration
//  */
// package top.yooonn.explore.notes.cloud.aio.other;
//
// import org.springframework.beans.factory.BeanFactory;
// import org.springframework.cglib.core.Signature;
// import org.springframework.cglib.reflect.FastClass;
//
// import java.lang.reflect.InvocationTargetException;
//
// public class DeclareByConfiguration$$FastClassBySpringCGLIB$$f6c96ff2
//         extends FastClass {
//
//     public BeanFactory $$beanFactory;
//
//     public DeclareByConfiguration$$FastClassBySpringCGLIB$$f6c96ff2(Class clazz) {
//         super(clazz);
//     }
//
//     @Override
//     public int getIndex(Signature signature) {
//         String string = ((Object) signature).toString();
//         switch (string.hashCode()) {
//             case -1830747790: {
//                 if (!string.equals("b()Lcom/ycourlee/explore/notes/cloud/aio/other/B;"))
//                     break;
//                 return 1;
//             }
//             case -1822988462: {
//                 if (!string.equals("a()Lcom/ycourlee/explore/notes/cloud/aio/other/A;"))
//                     break;
//                 return 2;
//             }
//             case -298197737: {
//                 if (!string.equals("afterSingletonsInstantiated()V"))
//                     break;
//                 return 0;
//             }
//             case 1826985398: {
//                 if (!string.equals("equals(Ljava/lang/Object;)Z"))
//                     break;
//                 return 3;
//             }
//             case 1913648695: {
//                 if (!string.equals("toString()Ljava/lang/String;"))
//                     break;
//                 return 4;
//             }
//             case 1984935277: {
//                 if (!string.equals("hashCode()I"))
//                     break;
//                 return 5;
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
//                         return 4;
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
//                         return 3;
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
//                         return 2;
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
//         DeclareByConfiguration declareByConfiguration = (DeclareByConfiguration) object;
//         try {
//             switch (n) {
//                 case 0: {
//                     declareByConfiguration.afterSingletonsInstantiated();
//                     return null;
//                 }
//                 case 1: {
//                     return declareByConfiguration.b();
//                 }
//                 case 2: {
//                     return declareByConfiguration.a();
//                 }
//                 case 3: {
//                     return new Boolean(declareByConfiguration.equals(objectArray[0]));
//                 }
//                 case 4: {
//                     return declareByConfiguration.toString();
//                 }
//                 case 5: {
//                     return new Integer(declareByConfiguration.hashCode());
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
//                     return new DeclareByConfiguration((BeanFactory) objectArray[0]);
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
//         return 5;
//     }
// }