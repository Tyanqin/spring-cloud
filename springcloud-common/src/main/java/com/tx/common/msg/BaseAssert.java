package com.tx.common.msg;


import org.springframework.lang.Nullable;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author TanXiao
 * @date 2022-06-10 20:40
 */
public abstract class BaseAssert {

    public static void isNull(@Nullable Object object, Supplier<BaseResponse> messageSupplier) {
        if (object != null) {
           nullSafeGet(messageSupplier);
        }
    }


    public static void notNull(@Nullable Object object, Supplier<BaseResponse> messageSupplier) {
        if (object == null) {
            nullSafeGet(messageSupplier);
        }
    }

    public static BaseResponse notNull(@Nullable Object object, String exMes,Function<String,BaseResponse> fun) {
        if (object == null) {
            return nullSafeGet(exMes,fun);
        }
        return nullSafeGet(object.toString(),fun);
    }

    public static void isTrue(boolean expression, Supplier<BaseResponse> messageSupplier) {
        if (!expression) {
              nullSafeGet(messageSupplier);
        }
    }

    @Nullable
    private static BaseResponse nullSafeGet(@Nullable Supplier<BaseResponse> messageSupplier) {
        return messageSupplier != null ? messageSupplier.get() : null;
    }

    @Nullable
    private static BaseResponse nullSafeGet(@Nullable String mes,@Nullable Function<String,BaseResponse> fun) {
        return fun != null ? fun.apply(mes) : null;
    }

}
