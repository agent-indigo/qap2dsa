package com.keyin.hynes.braden.qap2dsa.classes;
import com.keyin.hynes.braden.qap2dsa.enums.SeatStatus;
public final class Seat {
    private SeatStatus status;
    public Seat(SeatStatus status) {
        this.status = status;
    }
    public Seat() {}
    public SeatStatus getStatus() {
        return status;
    }
    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
