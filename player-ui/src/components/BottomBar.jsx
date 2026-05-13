import { useState } from 'react';

function BottomBar() {
    const [showCopiedToClipboard, setShowCopiedToClipboard] = useState(false);

    const handleCopy = async (text) =>{
        await navigator.clipboard.writeText(text)
    }
    const handleCopyComplete = (text) =>{
        if(showCopiedToClipboard) return;
        setShowCopiedToClipboard(true);
        setTimeout(() =>{
            setShowCopiedToClipboard(false);
        }, 1000)
    }

    return (
        <div style={styles.container}>
            <div style={{
                textAlign: "left"
            }}>
                <span>Server IP: </span>
                <span style={{
                    position: 'relative'
                }}>
                    <button
                      onMouseEnter={(e) =>{
                          e.currentTarget.style.color = "yellow"
                      }}
                      onMouseLeave={(e) =>{
                          e.currentTarget.style.color = "white"
                      }}
                      style={{
                          alignItems: "left",
                          padding: "0px",
                          backgroundColor: 'rgba(0, 0, 0, 0)',
                          borderColor: 'rgba(0, 0, 0, 0)',
                          transition: "color 0.08s ease-in-out",
                          fontSize: "16px"
                      }}
                      onClick={(e) => {
                          const textToCopy = e.currentTarget.textContent
                          handleCopy(textToCopy).then(handleCopyComplete(textToCopy))
                      }}
                    ><b>usurvive.net</b>
                    </button>
                    {showCopiedToClipboard && (
                      <div style={{
                          position: 'absolute',
                          top: '-20%',
                          left: '100%',
                          background: 'black',
                          color: 'white',
                          padding: '2px',
                          fontSize: '12px',
                          whiteSpace: 'nowrap'
                      }}>
                          <text
                            style={{
                                fontSize: '12px'
                            }}
                          >Copied to clipboard!</text>
                      </div>
                    )}
                </span>
                <br/>
                <text>Again</text>
            </div>

            <div style={styles.right}>
                <text>Right</text>
            </div>

        </div>
    );
}

const styles = {
    container: {
        display: "flex",
        justifyContent: "space-between",
        alignItems: "center",
        position: "fixed",
        padding: "10px 20px",
        bottom: "0",
        left: "0",
        width: "100%",
        backgroundColor: "#212223",
        color: "white"
    },
    right: {
        display: "flex",
        justifyContent: "right"
    }
};

export default BottomBar;