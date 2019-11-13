package cn.wxingzou.groupbooking;

import cn.wxingzou.flowengine.result.FailReason;
import cn.wxingzou.flowengine.result.Result;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/13 17:05
 **/
public class ResultDTO<T> implements Result<T, FailReasonDTO> {

    private boolean success;
    private T result;
    private FailReason<FailReasonDTO> failReason;

    public ResultDTO(boolean success) {
        this.success = success;
    }

    public ResultDTO(boolean success, FailReason<FailReasonDTO> failReason) {
        this.success = success;
        this.failReason = failReason;
    }

    public ResultDTO(boolean success, T result, FailReason<FailReasonDTO> failReason) {
        this.success = success;
        this.result = result;
        this.failReason = failReason;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public T getResult() {
        return result;
    }

    @Override
    public FailReason<FailReasonDTO> getFailReason() {
        return failReason;
    }

    public static Build getBuild() {
        return new Build();
    }

    public static class Build<T> {
        private boolean success;
        private T data;
        private FailReason<FailReasonDTO> failReason;

        public Build success() {
            this.success = true;
            return this;
        }

        public Build success(T data) {
            this.success = true;
            this.data = data;
            return this;
        }


        public Build fail(FailReasonDTO dto) {
            this.success = false;
            this.failReason = new FailReasonImpl<FailReasonDTO>(dto);
            return this;
        }

        public ResultDTO build() {
            return new ResultDTO(success, data, failReason);
        }

    }

}
