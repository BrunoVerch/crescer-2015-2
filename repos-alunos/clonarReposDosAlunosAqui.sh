declare -a nomesAlunos=("angelo5014" "BrunoVerch" "danielempaz" "dodireis" "emmanoelf" "ericgottschalk" "estervincensi" "FelipeM920" "gustavorborba" "iagodahlem" "JulioCROliveira" "Leonardo-Alves" "LucasKauer" "marcoskoch" "MarvinSantos" "maxrib" "OseiasODSR10" "pablobrodt" "renanpvaz" "Sergiobernardesjr" "Tefferson" "TiagoPintoAlves" "williamcardozo" "WillianWerlang")

for nomeAluno in "${nomesAlunos[@]}"
do
    mkdir $nomeAluno
	cd $nomeAluno
	git clone https://github.com/$nomeAluno/crescer-2015-2.git
	cd ..
done