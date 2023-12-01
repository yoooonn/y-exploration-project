// /*
//  * Decompiled with CFR.
//  *
//  * Could not load the following classes:
//  *  top.yooonn.explore.notes.cloud.aio.other.A
//  *  top.yooonn.explore.notes.cloud.aio.other.B
//  *  top.yooonn.explore.notes.cloud.aio.other.DeclareByConfiguration
//  */
// package top.yooonn.explore.notes.cloud.aio.other;
//
// import org.springframework.beans.BeansException;
// import org.springframework.beans.factory.BeanFactory;
// import org.springframework.cglib.core.ReflectUtils;
// import org.springframework.cglib.core.Signature;
// import org.springframework.cglib.proxy.Callback;
// import org.springframework.cglib.proxy.MethodInterceptor;
// import org.springframework.cglib.proxy.MethodProxy;
// import org.springframework.cglib.proxy.NoOp;
//
// import java.lang.reflect.Method;
//
// public class DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0
//         extends DeclareByConfiguration
//         implements ConfigurationClassEnhancer.EnhancedConfiguration {
//
//     private              boolean           CGLIB$BOUND;
//     public static        Object            CGLIB$FACTORY_DATA;
//     private static final ThreadLocal       CGLIB$THREAD_CALLBACKS;
//     private static final Callback[]        CGLIB$STATIC_CALLBACKS;
//     private              MethodInterceptor CGLIB$CALLBACK_0;
//     private              MethodInterceptor CGLIB$CALLBACK_1;
//     private              NoOp              CGLIB$CALLBACK_2;
//     private static       Object            CGLIB$CALLBACK_FILTER;
//     private static final Method            CGLIB$b$1$Method;
//     private static final MethodProxy       CGLIB$b$1$Proxy;
//     private static final Object[]          CGLIB$emptyArgs;
//     private static final Method            CGLIB$a$2$Method;
//     private static final MethodProxy       CGLIB$a$2$Proxy;
//     private static final Method            CGLIB$setBeanFactory$7$Method;
//     private static final MethodProxy       CGLIB$setBeanFactory$7$Proxy;
//     public               BeanFactory       $$beanFactory;
//
//     static void CGLIB$STATICHOOK3() {
//         CGLIB$THREAD_CALLBACKS = new ThreadLocal();
//         CGLIB$emptyArgs = new Object[0];
//         Class<?> clazz = Class.forName("top.yooonn.explore.notes.cloud.aio.other.DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0");
//         Class<?> clazz2 = Class.forName("org.springframework.beans.factory.BeanFactoryAware");
//         CGLIB$setBeanFactory$7$Method = ReflectUtils.findMethods(new String[]{"setBeanFactory", "(Lorg/springframework/beans/factory/BeanFactory;)V"}, clazz2.getDeclaredMethods())[0];
//         CGLIB$setBeanFactory$7$Proxy = MethodProxy.create(clazz2, clazz, "(Lorg/springframework/beans/factory/BeanFactory;)V", "setBeanFactory", "CGLIB$setBeanFactory$7");
//         clazz2 = Class.forName("top.yooonn.explore.notes.cloud.aio.other.DeclareByConfiguration");
//         Method[] methodArray = ReflectUtils.findMethods(new String[]{"b", "()Lcom/ycourlee/explore/notes/cloud/aio/other/B;", "a", "()Lcom/ycourlee/explore/notes/cloud/aio/other/A;"}, clazz2.getDeclaredMethods());
//         CGLIB$b$1$Method = methodArray[0];
//         CGLIB$b$1$Proxy = MethodProxy.create(clazz2, clazz, "()Lcom/ycourlee/explore/notes/cloud/aio/other/B;", "b", "CGLIB$b$1");
//         CGLIB$a$2$Method = methodArray[1];
//         CGLIB$a$2$Proxy = MethodProxy.create(clazz2, clazz, "()Lcom/ycourlee/explore/notes/cloud/aio/other/A;", "a", "CGLIB$a$2");
//     }
//
//     final B CGLIB$b$1() {
//         return super.b();
//     }
//
//     public final B b() {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//         if (methodInterceptor == null) {
//             DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.CGLIB$BIND_CALLBACKS(this);
//             methodInterceptor = this.CGLIB$CALLBACK_0;
//         }
//         if (methodInterceptor != null) {
//             return (B) methodInterceptor.intercept(this, CGLIB$b$1$Method, CGLIB$emptyArgs, CGLIB$b$1$Proxy);
//         }
//         return super.b();
//     }
//
//     final A CGLIB$a$2() {
//         return super.a();
//     }
//
//     public final A a() {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//         if (methodInterceptor == null) {
//             DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.CGLIB$BIND_CALLBACKS(this);
//             methodInterceptor = this.CGLIB$CALLBACK_0;
//         }
//         if (methodInterceptor != null) {
//             return (A) methodInterceptor.intercept(this, CGLIB$a$2$Method, CGLIB$emptyArgs, CGLIB$a$2$Proxy);
//         }
//         return super.a();
//     }
//
//     final void CGLIB$setBeanFactory$7(BeanFactory beanFactory) throws BeansException {
//         super.setBeanFactory(beanFactory);
//     }
//
//     @Override
//     public final void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_1;
//         if (methodInterceptor == null) {
//             DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.CGLIB$BIND_CALLBACKS(this);
//             methodInterceptor = this.CGLIB$CALLBACK_1;
//         }
//         if (methodInterceptor != null) {
//             Object object = methodInterceptor.intercept(this, CGLIB$setBeanFactory$7$Method, new Object[]{beanFactory}, CGLIB$setBeanFactory$7$Proxy);
//             return;
//         }
//         super.setBeanFactory(beanFactory);
//     }
//
//     public static MethodProxy CGLIB$findMethodProxy(Signature signature) {
//         String string = ((Object) signature).toString();
//         switch (string.hashCode()) {
//             case -1830747790: {
//                 if (!string.equals("b()Lcom/ycourlee/explore/notes/cloud/aio/other/B;"))
//                     break;
//                 return CGLIB$b$1$Proxy;
//             }
//             case -1822988462: {
//                 if (!string.equals("a()Lcom/ycourlee/explore/notes/cloud/aio/other/A;"))
//                     break;
//                 return CGLIB$a$2$Proxy;
//             }
//             case 2095635076: {
//                 if (!string.equals("setBeanFactory(Lorg/springframework/beans/factory/BeanFactory;)V"))
//                     break;
//                 return CGLIB$setBeanFactory$7$Proxy;
//             }
//         }
//         return null;
//     }
//
//     public DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0(BeanFactory beanFactory) {
//         DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0 declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0 = this;
//         super(beanFactory);
//         DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.CGLIB$BIND_CALLBACKS(declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0);
//     }
//
//     public static void CGLIB$SET_THREAD_CALLBACKS(Callback[] callbackArray) {
//         CGLIB$THREAD_CALLBACKS.set(callbackArray);
//     }
//
//     public static void CGLIB$SET_STATIC_CALLBACKS(Callback[] callbackArray) {
//         CGLIB$STATIC_CALLBACKS = callbackArray;
//     }
//
//     private static final void CGLIB$BIND_CALLBACKS(Object object) {
//         block2:
//         {
//             Object object2;
//             DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0 declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0;
//             block3:
//             {
//                 declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0 = (DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0) object;
//                 if (declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.CGLIB$BOUND)
//                     break block2;
//                 declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.CGLIB$BOUND = true;
//                 object2 = CGLIB$THREAD_CALLBACKS.get();
//                 if (object2 != null)
//                     break block3;
//                 object2 = CGLIB$STATIC_CALLBACKS;
//                 if (CGLIB$STATIC_CALLBACKS == null)
//                     break block2;
//             }
//             Callback[] callbackArray = (Callback[]) object2;
//             DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0 declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d02 = declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0;
//             declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d02.CGLIB$CALLBACK_2 = (NoOp) callbackArray[2];
//             declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d02.CGLIB$CALLBACK_1 = (MethodInterceptor) callbackArray[1];
//             declareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d02.CGLIB$CALLBACK_0 = (MethodInterceptor) callbackArray[0];
//         }
//     }
//
//     static {
//         DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.CGLIB$STATICHOOK4();
//         DeclareByConfiguration$$EnhancerBySpringCGLIB$$dc9076d0.CGLIB$STATICHOOK3();
//     }
//
//     static void CGLIB$STATICHOOK4() {
//     }
// }
