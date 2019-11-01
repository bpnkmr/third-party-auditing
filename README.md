# third-party-auditing
[Final Year] Collaboratively worked with a team of 4 to design and develop an auditing scheme for cloud storage which aims at maintaining data integrity along with the confidentiality of user data.

1. SYSTEM MODULES :

1.1. KEY GENERATION
In this module, the proposed system will generate key using the SHA-1 Hashing Algorithm. This key is generated after encryption phase. The hash function is used to index the original value or key and then used later each time the data
associated with the value or key is to be retrieved. Thus, hashing is always a one-wayoperation. This key is used for integrity checking and compar
ing the documents character-by-character. Since it is very sensitive every change in character will create a new hash code for the same document.

1.2. ENCRYPTION/DECRYPTION

1.2.1 ENCRYPTION PROCESS
Following are the working of the encryption process of AES algorithm :

• Byte Substitution (Sub Bytes) : Byte substitution by based on the ﬁxed table of input
is in bytes and the result also will be the matrix of four columns and rows.

• Shift rows : The shifting processing carried out in the matrix by shifting the rows to
the left one by one. In the shifting process if any entries are fall of then those entries
shifted or reinserted right side of the row. It is important for the encryption of the
data given as the input.
    • The ﬁrst row in the matrix is not shifted. 
    • While the second row shifted to one position from current position to the left. 
    • Then third row shifted two positions to the left. • Fourthrow is shifted three positions to the left. 
    • One by one row shifted to the left and any rows fall of, it reinserted to the right. 
    • New matrix will the same number of bytes 16 but shifted as above with each other.

• MixColumns : Mix the four bytes by using the functions using math. In this it get
the four byte of inputs and writes the newly generated bytes in which it replaces the
existing data. It will write the other atrix of newly generated data.

• Add Round Key : The 16 bytes of the matrix are now considered as 128 bits and
are XOR-ed to the 128 bits of the round key. If this is the last round then the output
is the cipher text. Otherwise, the resulting 128 bits are interpreted as 16 bytes and we
begin another similar round.


1.2.2 DECRYPTION PROCESS
The decryption process is exactly the reverse order of the AES encryption steps. In which the steps consist of the reversed order processes :
    • Add round key 
    • Mix columns 
    • Shift rows 
    • Byte substitution

1.3. UPLOAD/DOWNLOAD
After encryption/decryption process the proposed system can make the ﬁles available for upload and download of the ﬁles.

1.4 TPA MODULE
TPA (Third-Party Auditor) module, the auditor will constantly check the integrity of the ﬁles. This integrity checking helps in maintaining the integrity of the ﬁle. The actions performed under TPA Module are as follows:
1. Check Integrity.
2. Send Notiﬁcation
