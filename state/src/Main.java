//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

interface  State{
    void play();
    void pause();
    void stop();
}

class PlayState implements State{
   @Override
    public void play(){
    System.out.println("Already Playing");
    }
    @Override
    public void pause(){
         System.out.println("pausing the player");
    }
    @Override
   public void stop(){
        System.out.println("stoping the player");
    }
}


class PauseState implements State{
    @Override
    public void play(){
        System.out.println("Resuming playing.");
    }
    @Override
    public void pause(){
        System.out.println("Already Paused");
    }
    @Override
    public void stop(){
        System.out.println("stopping from pause state");
    }
}


class StopState implements State{
    @Override
    public void play(){
        System.out.println("Starting playback.");
    }
    @Override
    public void pause(){
        System.out.println("cannot pause, Player is stopped");
    }
    @Override
    public void stop(){
        System.out.println("Already stop");
    }
}


class MediaPlayer{

    private State state;
    public  MediaPlayer(){
        this.state = new StopState();
    }

    public void setState(State state){
        this.state = state;
    }

    public void play(){
        state.play();
        if(!(state instanceof PlayState)){
            setState(new PlayState());
        }
    }

    public void pause(){
        state.pause();
        if(!(state instanceof PauseState)){
            setState(new PauseState());
        }
    }

    public void stop(){
        state.stop();
        if(!(state instanceof StopState)){
            setState(new StopState());
        }
    }


}
public class Main {
    public static void main(String[] args) {
         MediaPlayer player = new MediaPlayer();
         player.play();
         player.pause();
         player.play();
         player.stop();
    }
}