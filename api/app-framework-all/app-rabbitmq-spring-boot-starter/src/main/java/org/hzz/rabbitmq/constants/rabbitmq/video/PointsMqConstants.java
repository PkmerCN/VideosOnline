package org.hzz.rabbitmq.constants.rabbitmq.video;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/29
 */
public interface PointsMqConstants {
    interface Exchange{
        /**
         * 学习视频
         */
        String POINTS_EXCHANGE = "points.exchange";
    }
    interface Queue{
        /**
         * 写回答
         */
        String WRITE_REPLY = "qa.points.queue";
        /**
         * 签到
         */
        String SIGN_IN = "sign.points.queue";

        /**
         * 学习视频
         */
        String LEARN_SECTION = "learning.points.queue";

        /**
         * 写笔记
         */
        String WRITE_NOTE = "note.new.points.queue";

        /**
         * 笔记被采纳
         */
        String NOTE_GATHERED = "note.gathered.points.queue";
    }

    interface Key{
        /**
         * 写回答
         */
        String WRITE_REPLY = "reply.new";
        /**
         * 签到
         */
        String SIGN_IN = "sign.in";

        /**
         * 学习视频
         */
        String LEARN_SECTION = "section_learned";

        /**
         * 写笔记
         */
        String WRITE_NOTE = "note.new";

        /**
         * 笔记被采纳
         */
        String NOTE_GATHERED = "note.gathered";
    }
}
