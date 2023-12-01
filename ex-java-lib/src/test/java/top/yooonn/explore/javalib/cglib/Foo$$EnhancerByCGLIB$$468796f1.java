// /*
//  * Decompiled with CFR.
//  *
//  * Could not load the following classes:
//  *  top.yooonn.explore.javalib.cglib.Foo
//  */
// package top.yooonn.explore.javalib.cglib;
//
// import net.sf.cglib.core.ReflectUtils;
// import net.sf.cglib.core.Signature;
// import net.sf.cglib.proxy.Callback;
// import net.sf.cglib.proxy.MethodInterceptor;
// import net.sf.cglib.proxy.MethodProxy;
//
// import java.lang.reflect.Method;
//
// public class Foo$$EnhancerByCGLIB$$468796f1
//         extends Foo {
//
//     private              boolean           CGLIB$BOUND;
//     public static        Object            CGLIB$FACTORY_DATA;
//     private static final ThreadLocal       CGLIB$THREAD_CALLBACKS;
//     private static final Callback[]        CGLIB$STATIC_CALLBACKS;
//     private              MethodInterceptor CGLIB$CALLBACK_0;
//     private static       Object            CGLIB$CALLBACK_FILTER;
//     private static final Method            CGLIB$getA$0$Method;
//     private static final MethodProxy       CGLIB$getA$0$Proxy;
//     private static final Object[]          CGLIB$emptyArgs;
//     private static final Method            CGLIB$setA$1$Method;
//     private static final MethodProxy       CGLIB$setA$1$Proxy;
//     private static final Method            CGLIB$toString$2$Method;
//     private static final MethodProxy       CGLIB$toString$2$Proxy;
//     private static final Method            CGLIB$b$3$Method;
//     private static final MethodProxy       CGLIB$b$3$Proxy;
//     private static final Method            CGLIB$equals$4$Method;
//     private static final MethodProxy       CGLIB$equals$4$Proxy;
//     private static final Method            CGLIB$hashCode$5$Method;
//     private static final MethodProxy       CGLIB$hashCode$5$Proxy;
//     private static final Method            CGLIB$clone$6$Method;
//     private static final MethodProxy       CGLIB$clone$6$Proxy;
//
//     public static void CGLIB$SET_STATIC_CALLBACKS(Callback[] callbackArray) {
//         CGLIB$STATIC_CALLBACKS = callbackArray;
//     }
//
//     public static void CGLIB$SET_THREAD_CALLBACKS(Callback[] callbackArray) {
//         CGLIB$THREAD_CALLBACKS.set(callbackArray);
//     }
//
//     public final Integer getA() {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//         if (methodInterceptor == null) {
//             Foo$$EnhancerByCGLIB$$468796f1.CGLIB$BIND_CALLBACKS((Object) this);
//             methodInterceptor = this.CGLIB$CALLBACK_0;
//         }
//         if (methodInterceptor != null) {
//             return (Integer) methodInterceptor.intercept((Object) this, CGLIB$getA$0$Method, CGLIB$emptyArgs, CGLIB$getA$0$Proxy);
//         }
//         return super.getA();
//     }
//
//     public final void setA(Integer n) {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//         if (methodInterceptor == null) {
//             Foo$$EnhancerByCGLIB$$468796f1.CGLIB$BIND_CALLBACKS((Object) this);
//             methodInterceptor = this.CGLIB$CALLBACK_0;
//         }
//         if (methodInterceptor != null) {
//             Object object = methodInterceptor.intercept((Object) this, CGLIB$setA$1$Method, new Object[]{n}, CGLIB$setA$1$Proxy);
//             return;
//         }
//         super.setA(n);
//     }
//
//     final Integer CGLIB$getA$0() {
//         return super.getA();
//     }
//
//     private static final void CGLIB$BIND_CALLBACKS(Object object) {
//         block2:
//         {
//             Object object2;
//             block3:
//             {
//                 Foo$$EnhancerByCGLIB$$468796f1 foo$$EnhancerByCGLIB$$468796f1 = (Foo$$EnhancerByCGLIB$$468796f1) ((Object) object);
//                 if (foo$$EnhancerByCGLIB$$468796f1.CGLIB$BOUND)
//                     break block2;
//                 foo$$EnhancerByCGLIB$$468796f1.CGLIB$BOUND = true;
//                 object2 = CGLIB$THREAD_CALLBACKS.get();
//                 if (object2 != null)
//                     break block3;
//                 object2 = CGLIB$STATIC_CALLBACKS;
//                 if (CGLIB$STATIC_CALLBACKS == null)
//                     break block2;
//             }
//             foo$$EnhancerByCGLIB$$468796f1.CGLIB$CALLBACK_0 = (MethodInterceptor) ((Callback[]) object2)[0];
//         }
//     }
//
//     final void CGLIB$setA$1(Integer n) {
//         super.setA(n);
//     }
//
//     static void CGLIB$STATICHOOK1() {
//         CGLIB$THREAD_CALLBACKS = new ThreadLocal();
//         CGLIB$emptyArgs = new Object[0];
//         Class<?> clazz = Class.forName("top.yooonn.explore.javalib.cglib.Foo$$EnhancerByCGLIB$$468796f1");
//         Class<?> clazz2 = Class.forName("java.lang.Object");
//         Method[] methodArray = ReflectUtils.findMethods(new String[]{"equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "clone", "()Ljava/lang/Object;"}, clazz2.getDeclaredMethods());
//         CGLIB$equals$4$Method = methodArray[0];
//         CGLIB$equals$4$Proxy = MethodProxy.create(clazz2, clazz, "(Ljava/lang/Object;)Z", "equals", "CGLIB$equals$4");
//         CGLIB$hashCode$5$Method = methodArray[1];
//         CGLIB$hashCode$5$Proxy = MethodProxy.create(clazz2, clazz, "()I", "hashCode", "CGLIB$hashCode$5");
//         CGLIB$clone$6$Method = methodArray[2];
//         CGLIB$clone$6$Proxy = MethodProxy.create(clazz2, clazz, "()Ljava/lang/Object;", "clone", "CGLIB$clone$6");
//         clazz2 = Class.forName("top.yooonn.explore.javalib.cglib.Foo");
//         Method[] methodArray2 = ReflectUtils.findMethods(new String[]{"getA", "()Ljava/lang/Integer;", "setA", "(Ljava/lang/Integer;)V", "toString", "()Ljava/lang/String;", "b", "()V"}, clazz2.getDeclaredMethods());
//         CGLIB$getA$0$Method = methodArray2[0];
//         CGLIB$getA$0$Proxy = MethodProxy.create(clazz2, clazz, "()Ljava/lang/Integer;", "getA", "CGLIB$getA$0");
//         CGLIB$setA$1$Method = methodArray2[1];
//         CGLIB$setA$1$Proxy = MethodProxy.create(clazz2, clazz, "(Ljava/lang/Integer;)V", "setA", "CGLIB$setA$1");
//         CGLIB$toString$2$Method = methodArray2[2];
//         CGLIB$toString$2$Proxy = MethodProxy.create(clazz2, clazz, "()Ljava/lang/String;", "toString", "CGLIB$toString$2");
//         CGLIB$b$3$Method = methodArray2[3];
//         CGLIB$b$3$Proxy = MethodProxy.create(clazz2, clazz, "()V", "b", "CGLIB$b$3");
//     }
//
//     final String CGLIB$toString$2() {
//         return super.toString();
//     }
//
//     final void CGLIB$b$3() {
//         super.b();
//     }
//
//     final boolean CGLIB$equals$4(Object object) {
//         return super.equals(object);
//     }
//
//     final int CGLIB$hashCode$5() {
//         return super.hashCode();
//     }
//
//     final Object CGLIB$clone$6() throws CloneNotSupportedException {
//         return super.clone();
//     }
//
//     public static MethodProxy CGLIB$findMethodProxy(Signature signature) {
//         String string = ((Object) signature).toString();
//         switch (string.hashCode()) {
//             case -1638303807: {
//                 if (!string.equals("setA(Ljava/lang/Integer;)V"))
//                     break;
//                 return CGLIB$setA$1$Proxy;
//             }
//             case -508378822: {
//                 if (!string.equals("clone()Ljava/lang/Object;"))
//                     break;
//                 return CGLIB$clone$6$Proxy;
//             }
//             case 2959315: {
//                 if (!string.equals("b()V"))
//                     break;
//                 return CGLIB$b$3$Proxy;
//             }
//             case 529159313: {
//                 if (!string.equals("getA()Ljava/lang/Integer;"))
//                     break;
//                 return CGLIB$getA$0$Proxy;
//             }
//             case 1826985398: {
//                 if (!string.equals("equals(Ljava/lang/Object;)Z"))
//                     break;
//                 return CGLIB$equals$4$Proxy;
//             }
//             case 1913648695: {
//                 if (!string.equals("toString()Ljava/lang/String;"))
//                     break;
//                 return CGLIB$toString$2$Proxy;
//             }
//             case 1984935277: {
//                 if (!string.equals("hashCode()I"))
//                     break;
//                 return CGLIB$hashCode$5$Proxy;
//             }
//         }
//         return null;
//     }
//
//     public Foo$$EnhancerByCGLIB$$468796f1() {
//         Foo$$EnhancerByCGLIB$$468796f1 foo$$EnhancerByCGLIB$$468796f1 = this;
//         Foo$$EnhancerByCGLIB$$468796f1.CGLIB$BIND_CALLBACKS((Object) foo$$EnhancerByCGLIB$$468796f1);
//     }
//
//     static {
//         Foo$$EnhancerByCGLIB$$468796f1.CGLIB$STATICHOOK1();
//     }
//
//     public final boolean equals(Object object) {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//         if (methodInterceptor == null) {
//             Foo$$EnhancerByCGLIB$$468796f1.CGLIB$BIND_CALLBACKS((Object) this);
//             methodInterceptor = this.CGLIB$CALLBACK_0;
//         }
//         if (methodInterceptor != null) {
//             Object object2 = methodInterceptor.intercept((Object) this, CGLIB$equals$4$Method, new Object[]{object}, CGLIB$equals$4$Proxy);
//             return object2 == null ? false : (Boolean) object2;
//         }
//         return super.equals(object);
//     }
//
//     public final String toString() {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//         if (methodInterceptor == null) {
//             Foo$$EnhancerByCGLIB$$468796f1.CGLIB$BIND_CALLBACKS((Object) this);
//             methodInterceptor = this.CGLIB$CALLBACK_0;
//         }
//         if (methodInterceptor != null) {
//             return (String) methodInterceptor.intercept((Object) this, CGLIB$toString$2$Method, CGLIB$emptyArgs, CGLIB$toString$2$Proxy);
//         }
//         return super.toString();
//     }
//
//     public final int hashCode() {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//         if (methodInterceptor == null) {
//             Foo$$EnhancerByCGLIB$$468796f1.CGLIB$BIND_CALLBACKS((Object) this);
//             methodInterceptor = this.CGLIB$CALLBACK_0;
//         }
//         if (methodInterceptor != null) {
//             Object object = methodInterceptor.intercept((Object) this, CGLIB$hashCode$5$Method, CGLIB$emptyArgs, CGLIB$hashCode$5$Proxy);
//             return object == null ? 0 : ((Number) object).intValue();
//         }
//         return super.hashCode();
//     }
//
//     protected final Object clone() throws CloneNotSupportedException {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//         if (methodInterceptor == null) {
//             Foo$$EnhancerByCGLIB$$468796f1.CGLIB$BIND_CALLBACKS((Object) this);
//             methodInterceptor = this.CGLIB$CALLBACK_0;
//         }
//         if (methodInterceptor != null) {
//             return methodInterceptor.intercept((Object) this, CGLIB$clone$6$Method, CGLIB$emptyArgs, CGLIB$clone$6$Proxy);
//         }
//         return super.clone();
//     }
//
//     public final void b() {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//         if (methodInterceptor == null) {
//             Foo$$EnhancerByCGLIB$$468796f1.CGLIB$BIND_CALLBACKS((Object) this);
//             methodInterceptor = this.CGLIB$CALLBACK_0;
//         }
//         if (methodInterceptor != null) {
//             Object object = methodInterceptor.intercept((Object) this, CGLIB$b$3$Method, CGLIB$emptyArgs, CGLIB$b$3$Proxy);
//             return;
//         }
//         super.b();
//     }
// }
