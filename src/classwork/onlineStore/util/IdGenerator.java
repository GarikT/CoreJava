package classwork.onlineStore.util;

import java.util.UUID;

public abstract class IdGenerator {
    public static String genrageId(){
        return UUID
                .randomUUID()
                .toString()
                .split("-")[0];
    }
}
